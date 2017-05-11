package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotations;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.compute.mbse.yawl.Arc;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;
import marking.NetMarking;
import yawlannotations.EnabledTransition;
import yawlannotations.SelectedArc;
import yawlannotations.YawlannotationsFactory;
import yawlannotations.YawlannotationsPackage;
/**
 * 
 * @author Thomas Bech Madsen
 *
 */
public class EnabledTransitionHandler implements IActionHandler{ //SE TUTORIAL 8C

	private YAWLSimulator app;
	
	public EnabledTransitionHandler(YAWLSimulator app) {
		super();
		this.app = app;	
	}
	
	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		NetAnnotations nas = app.getNetAnnotations();
		NetAnnotation current = nas.getCurrent();
		FlatAccess flatNet = app.getFlatAccess();
		
		if(current.getObjectAnnotations().contains(annotation)){
			Object object = annotation.getObject();
			if(object instanceof Transition){
				object = flatNet.resolve((Transition) object);
			Transition transition = (Transition) object;
			NetMarking netMarking = app.computeMarking();
			if(app.enabled(flatNet, netMarking, transition)){
				//YAWLSimulator causes this error
				NetMarking newNetMarking = app.fireTransition(flatNet, netMarking, getSelectedInArcs((EnabledTransition) annotation), transition, getSelectedOutArcs((EnabledTransition) annotation));
				NetAnnotation netAnnotation = app.computeAnnotation(newNetMarking);
				netAnnotation.setNet(app.getPetrinet());
				app.deleteNetAnnotationAfterCurrent();
				app.addNetAnnotationAsCurrent(netAnnotation);
				app.update();
				return true;
			}
			}
		}
		return false;
	}

	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}
	
	private Arc getSelectedInArcs(EnabledTransition enabledTransition){
		EnabledTransition resolved = enabledTransition.getResolved();
		if(resolved == null){
			resolved = enabledTransition;
		}
		for(SelectedArc selectedArc : resolved.getInArcs()){
			if(selectedArc.isSelected()){
				return (Arc) selectedArc.getObject();
			}
		}
		return null;
	}
	
	private Collection<Arc> getSelectedOutArcs(EnabledTransition enabledTransition){
		EnabledTransition resolved = enabledTransition.getResolved();
		Collection<Arc> arcs = new HashSet<Arc>();
		if(resolved == null){
			resolved = enabledTransition;
		}
		for(SelectedArc selectedArc : resolved.getOutArcs()){
			if(selectedArc.isSelected()){
				arcs.add((Arc)selectedArc.getObject());
			}
		}
		return arcs;
	}
}
