package application;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.applications.ui.ApplicationUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import dk.dtu.compute.mbse.yawl.Arc;
import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;
import marking.NetMarking;
import yawlannotations.EnabledTransition;
import yawlannotations.Marking;
import yawlannotations.SelectedArc;
import yawlannotations.YawlannotationsFactory;

public class YAWLSimulator extends ApplicationWithUIManager{

	FlatAccess flatAccess;
	private NetChangeListener ncl;
	
	public YAWLSimulator(PetriNet petrinet) {
		super(petrinet);
		getNetAnnotations().setName("A YAWL Simulator");
		ApplicationUIManager manager = this.getPresentationManager();
		manager.addActionHandler(new EnabledTransitionHandler(this));
		manager.addActionHandler(new SelectArcHandler(this));
		manager.addPresentationHandler(new YAWLAnnotationsPresentationHandler());
		
		ncl = new NetChangeListener(this);
	}
	
	public void initializeContents(){
		NetMarking init = computeInitialMarking();
		NetAnnotation initAnnon = computeAnnotation(init);
		initAnnon.setNet(this.getPetrinet());
		this.getNetAnnotations().getNetAnnotations().add(initAnnon);
		this.getNetAnnotations().setCurrent(initAnnon);
	}
	public NetAnnotation computeAnnotation(NetMarking nm){
		FlatAccess flatAccess = getFlatAccess();
		NetAnnotation anno = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		anno.setNet(getPetrinet());
		Map<Object,Marking> p2mAnno = new HashMap<Object,Marking>();
		//TODO Place skal laves om til vores egen
		for(org.pnml.tools.epnk.pnmlcoremodel.Place place : nm.GetSupport()) {
			int value = nm.GetMarking(place);
			if(value > 0){
				Marking markAnno = YawlannotationsFactory.eINSTANCE.createMarking();
				markAnno.setValue(value);
				markAnno.setObject(place);
				anno.getObjectAnnotations().add(markAnno);
				p2mAnno.put(place, markAnno);
				
				//TODO Also annotate reference places with the current marking of the place.
				
			}
		}
		
		Set<Transition> enabled = new HashSet<Transition>();
		//TODO Transition skal laves om til vores egen
		for(org.pnml.tools.epnk.pnmlcoremodel.Transition t : flatAccess.getTransitions()){
			if(t instanceof Transition){
				if(enabled(flatAccess, nm, (Transition) t)){
					enabled.add((Transition) t);
					
					EnabledTransition transAnno = YawlannotationsFactory.eINSTANCE.createEnabledTransition();
					transAnno.setObject(t);
					anno.getObjectAnnotations().add(transAnno);
					
					//TODO also annotate reference transitions referring to this transition
					
					if(YAWLFunctions.getJoinType((dk.dtu.compute.mbse.yawl.Transition)t).equals(TType.XOR)){
						boolean first = true;
						for(Object in : flatAccess.getIn(t)){
							if(in instanceof Arc){
								if(!YAWLFunctions.isResetArc((Arc) in)){
									Marking sourceMark = p2mAnno.get(((Arc) in).getSource());
									if(sourceMark != null){
										SelectedArc arcAnno = YawlannotationsFactory.eINSTANCE.createSelectedArc();
										arcAnno.setObject(((Arc) in));
										arcAnno.setSourceMarking(sourceMark);
										arcAnno.setTargetTransition(transAnno);
										if(first){
											arcAnno.setSelected(true);
											first = false;
										} else{
											arcAnno.setSelected(false);
										}
										anno.getObjectAnnotations().add(arcAnno);
									}
								}
							}
						}
					}
					
					if(YAWLFunctions.getSplitType((dk.dtu.compute.mbse.yawl.Transition)t).equals(TType.XOR)){
						boolean first = true;
						for(Object out : flatAccess.getOut(t)){
							if(out instanceof Arc){
								SelectedArc arcAnno = YawlannotationsFactory.eINSTANCE.createSelectedArc();
								arcAnno.setObject(((Arc) out));
								arcAnno.setSourceTransition(transAnno);
								if(first){
									arcAnno.setSelected(true);
									first = false;
								} else {
									arcAnno.setSelected(false);
								}
								anno.getObjectAnnotations().add(arcAnno);
							}
						}
					}
					
					if(YAWLFunctions.getSplitType((dk.dtu.compute.mbse.yawl.Transition)t).equals(TType.XOR)){
						for(Object out : flatAccess.getOut(t)){
							if(out instanceof Arc){
								SelectedArc arcAnno = YawlannotationsFactory.eINSTANCE.createSelectedArc();
								arcAnno.setObject(((Arc) out));
								arcAnno.setSourceTransition(transAnno);
								arcAnno.setSelected(true);
								anno.getObjectAnnotations().add(arcAnno);
							}
						}
					}
				}
			}
		}
		return anno;
	}
	
	public NetMarking computeInitialMarking(){
		NetMarking mark = new NetMarking();
		for(org.pnml.tools.epnk.pnmlcoremodel.Place place : getFlatAccess().getPlaces())
		{
			if(place instanceof Place && YAWLFunctions.getType((dk.dtu.compute.mbse.yawl.Place)place) == PType.START)
			{
				mark.SetMarking(place, 1);
			}
		}
		return mark;
	}
	
	public NetMarking computeMarking(){
		NetMarking mark = new NetMarking();
		for(ObjectAnnotation annon : this.getNetAnnotations().getObjectAnnotations()){
			if(annon instanceof Marking)
			{
				Marking markAnnon = (Marking) annon;
				Object object = markAnnon.getObject();
				int value = markAnnon.getValue();
				if(object instanceof Place && value > 0){
					Place place = (Place) object;
					mark.SetMarking(place, value);
				}
			}
		}
		return mark;
	}
	
	public boolean enabled(FlatAccess fa, NetMarking nm, Transition t){
		TType joinType = YAWLFunctions.getJoinType(t);
		if(joinType.equals(TType.AND)||joinType.equals(TType.OR)){
			for(Object in : fa.getIn(t)){
				if(in instanceof Arc) {
					Arc arc = (Arc) in;
					if (!YAWLFunctions.isResetArc(arc)){
						Object source = arc.getSource();
						if (source instanceof Place){
							source = fa.resolve((Place) source);
							if(source instanceof Place){
								if(nm.GetMarking((Place) source) < 1){
									return false;
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
			}
			return true;
		}
		else if(joinType.equals(TType.OR)||joinType.equals(TType.XOR)){
			for(Object in : fa.getIn(t)){
				if(in instanceof Arc){
					Arc arc = (Arc) in;
					if(!YAWLFunctions.isResetArc(arc)) {
						Object source = arc.getSource();
						if(source instanceof Place){
							source = fa.resolve((Place) source);
							if(source instanceof Place) {
								if(nm.GetMarking((Place) source) > 0){
									return true;
								}
							}
						}
					}
				}
			}
			return false;
		}
		return false;
	}
	
	public NetMarking fireTransition(FlatAccess fa, NetMarking n1, Arc selectedInArc, Transition t, Collection<Arc> selectedOutArcs){
		//TODO
		return null;
	}
	
	public FlatAccess getFlatAccess(){
		if(flatAccess == null){
			flatAccess = FlatAccess.getFlatAccess(this.getPetrinet());
			if(ncl != null){
				flatAccess.addInvalidationListener(ncl);
			}
		}
		return flatAccess;
	}
	
	public boolean isSavable(){
		//TODO
		return false;
	}
	
	public void shutDown(){
		//TODO
	}
	
}
