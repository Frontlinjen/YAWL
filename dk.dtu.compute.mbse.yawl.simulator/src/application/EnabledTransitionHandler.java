package application;

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
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.compute.mbse.yawl.Arc;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;
import yawlannotations.EnabledTransition;
import yawlannotations.SelectedArc;
import yawlannotations.YawlannotationsFactory;
import yawlannotations.YawlannotationsPackage;

public class EnabledTransitionHandler implements IActionHandler{

	private YAWLSimulator app;
	
	public EnabledTransitionHandler(YAWLSimulator app) {
		super();
		this.app = app;	
	}
	
	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		NetAnnotations nas = app.getNetAnnotations();
		NetAnnotation na = nas.getCurrent();
		if(na.getObjectAnnotations().contains(nas)){
			Object object = annotation.getObject();
			if(annotation instanceof TransitionNode){
				//NetFunctions.resolve((TransitionNode)annotation);
				FlatAccess flatAccess = app.getFlatAccess();
				object = flatAccess.resolve((TransitionNode)annotation);
			}
			if(object instanceof Transition && object instanceof EnabledTransition){
				EnabledTransition enabledTransition = (EnabledTransition) annotation;
				
				//TODO verify: Assuming that EnabledTransitions are always enabled we do not need a if statement
				Collection<Arc> inArcs = new HashSet<Arc>();
				for(SelectedArc a : enabledTransition.getInArcs()){
					Object o = a.getObject();
					if (o instanceof Arc && !a.isSelected()) {
						inArcs.add((Arc) o);
					}
				}
				Collection<Arc> outArcs = new HashSet<Arc>();
				for(SelectedArc a : enabledTransition.getOutArcs()){
					Object o = a.getObject();
					if (o instanceof Arc && !a.isSelected()) {
						outArcs.add((Arc) o);
					}
				}
				//TODO Check hvilken type af arc der er snakke om, hvis der er mulighed for at få flere inArcs så vælg en af dem og glem resten
				app.fireTransition(app.getFlatAccess(), app.computeMarking(), selectedInArc, enabledTransition, outArcs);
				//return app.fireTransition(app.getFlatAccess(), app.computeMarking(), inArcs, enabledTransition, outArcs);
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

}
