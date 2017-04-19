package application;

import javax.swing.text.StyleConstants.ColorConstants;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IPresentationHandler;
import org.pnml.tools.epnk.applications.ui.figures.PolylineOverlay;
import org.pnml.tools.epnk.applications.ui.figures.RectangleOverlay;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.compute.mbse.yawl.Arc;
import yawlannotations.EnabledTransition;
import yawlannotations.SelectedArc;

public class YAWLAnnotationsPresentationHandler implements IPresentationHandler{

	@Override
	public IFigure handle(ObjectAnnotation annotation, AbstractGraphicalEditPart editPart) {
		if(annotation instanceof EnabledTransition){
			if(editPart instanceof GraphicalEditPart){
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				java.lang.Object modelObject = graphicalEditPart.resolveSementicElement();
				if(modelObject instanceof TransitionNode){
					RectangleOverlay overlay = new RectangleOverlay(graphicalEditPart);
					overlay.setForegroundColor(org.eclipse.draw2d.ColorConstants.blue);
					overlay.setBackgroundColor(org.eclipse.draw2d.ColorConstants.blue);
					return overlay;
				}
			}
		} else if (annotation instanceof SelectedArc){
			SelectedArc selectArc = (SelectedArc) annotation;
			if(editPart instanceof ConnectionNodeEditPart){
				ConnectionNodeEditPart connectionNodeEditPart = (ConnectionNodeEditPart) editPart;
				java.lang.Object modelObject = connectionNodeEditPart.resolveSemanticElement();
				if(modelObject instanceof Arc){
					PolylineOverlay overlay = new PolylineOverlay(connectionNodeEditPart);
					if(!selectArc.isSelected()){
						overlay.setForegroundColor(org.eclipse.draw2d.ColorConstants.lightGray);
						overlay.setBackgroundColor(org.eclipse.draw2d.ColorConstants.lightGray);
					} else {
						overlay.setForegroundColor(org.eclipse.draw2d.ColorConstants.blue);
						overlay.setBackgroundColor(org.eclipse.draw2d.ColorConstants.blue);
					}
					return overlay;
				}
			}
		}
		return null;
	}

}
