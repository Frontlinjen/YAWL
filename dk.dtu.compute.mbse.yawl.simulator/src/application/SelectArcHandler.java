package application;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;

import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;
import yawlannotations.EnabledTransition;
import yawlannotations.Marking;
import yawlannotations.SelectedArc;

public class SelectArcHandler implements IActionHandler{

	private YAWLSimulator sim;
	
	public SelectArcHandler(YAWLSimulator sim){
		super();
		this.sim = sim;
	}
	
	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}
	
	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		if(annotation instanceof SelectedArc){
			SelectedArc selectedArc = (SelectedArc) annotation;
			EnabledTransition targetTransition = (EnabledTransition) selectedArc.getTargetTransition();
			EnabledTransition sourceTransition = (EnabledTransition) selectedArc.getSourceTransition();
			Marking sourceMarking = selectedArc.getSourceMarking();
			
			if(targetTransition != null){
				if(!selectedArc.isSelected() &&
					sourceMarking != null &&
					sourceMarking.getValue() > 0){
				Transition transition = (Transition) ((yawlannotations.EnabledTransition) targetTransition).getTransition();
				if(YAWLFunctions.getJoinType(transition).equals(TType.XOR)){
					for(SelectedArc s_arc: targetTransition.getInArcs()){
						s_arc.setSelected(false);
					}
					selectedArc.setSelected(true);
					sim.update();
					return true;
				}
				}else if(sourceTransition != null){
					Transition transition = (Transition) ((yawlannotations.EnabledTransition) sourceTransition).getTransition();
					TType cType = YAWLFunctions.getSplitType(transition);
					if(cType.equals(TType.XOR)){
						for(SelectedArc s_arc: sourceTransition.getOutArcs()){
							s_arc.setSelected(false);
						}
						selectedArc.setSelected(true);
						sim.update();
						return true;
				}else if(cType.equals(TType.OR)){
					selectedArc.setSelected(!selectedArc.isSelected());
					boolean notEmpty = false;
					for (SelectedArc s_arc: sourceTransition.getOutArcs()){
						if(s_arc.isSelected()){
							notEmpty = true;
							break;
						}
					}
					if(!notEmpty){
						for (SelectedArc s_arc: sourceTransition.getOutArcs()){
							if(s_arc != selectedArc){
								s_arc.setSelected(true);
								break;
							}
						}
					}
					sim.update();
					return true;
				}
					
				}
			}
		}
		return false;
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

}
