package dk.dtu.compute.mbse.yawl.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import dk.dtu.compute.mbse.yawl.SType;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;

/**
 * 
 * @author Mikkel
 *
 */

public class YAWLSTransitionFigure extends TransitionFigure{

	private TType type;
	
	public YAWLSTransitionFigure(Transition transition) {
		super(transition);
		type = YAWLFunctions.getSplitType((dk.dtu.compute.mbse.yawl.Transition) transition);
	}
	
	@Override
	public void update() {
		TType oldtype = type;
		type = YAWLFunctions.getSplitType((dk.dtu.compute.mbse.yawl.Transition) transition);
		if (oldtype != type) {
			// only call the repaint() method, when there was a change that has
			// an effect to the graphical appearance of the transition
			this.repaint();
		}
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		
		graphics.setLineWidth(1);
		Rectangle rectangle = this.getClientArea();
		int d1 = rectangle.width / 3;
		
		if(type.equals(SType.XOR)){
			graphics.pushState();
			Display display = Display.getCurrent();
			Color white = display.getSystemColor(SWT.COLOR_WHITE);
			graphics.setBackgroundColor(white);
			graphics.setLineWidth(1);
			int x1 = rectangle.x + 2*d1;
			int y1 = rectangle.height;
			int x2 = rectangle.width;
			int y2 = rectangle.height / 2;
			int x3 = x1;
			int y3 = rectangle.y;
			graphics.drawLine(x1, y1, x2, y2);
			graphics.drawLine(x3, y3, x2, y2);
			graphics.drawLine(x1, y1, x3, y3);
			graphics.popState();
		}
		
		if(type.equals(SType.AND)){
			graphics.pushState();
			Display display = Display.getCurrent();
			Color white = display.getSystemColor(SWT.COLOR_WHITE);
			graphics.setBackgroundColor(white);
			graphics.setLineWidth(1);
			int x11 = 2 * d1;
			int y11 = rectangle.height;
			int x21 = x11;
			int y21 = rectangle.y;
			graphics.drawLine(x11,y11, x21,y21);
			int x1 = rectangle.width;
			int y1 = rectangle.height;
			int x2 = x1;
			int y2 = rectangle.y;
			int x3 = 2 * d1;
			int y3 = rectangle.height / 2;
			graphics.drawLine(x1, y1, x3, y3);
			graphics.drawLine(x3, y3, x2, y2);
			graphics.popState();
		}
		
		if(type.equals(SType.OR)){
			graphics.pushState();
			Display display = Display.getCurrent();
			Color white = display.getSystemColor(SWT.COLOR_WHITE);
			graphics.setBackgroundColor(white);
			graphics.setLineWidth(1);
			int x11 = 2 * d1;
			int y11 = rectangle.height;
			int x21 = x11;
			int y21 = rectangle.y;
			graphics.drawLine(x11,y11, x21,y21);
			int x1 = rectangle.width - (rectangle.width / 6);
			int y1 = rectangle.height;
			int x2 = rectangle.width;
			int y2 = rectangle.height / 2;
			int x3 = x1;
			int y3 = rectangle.y;
			int x4 = rectangle.x + 2 * d1;
			int y4 = y2;
			graphics.drawLine(x1, y1, x2, y2);
			graphics.drawLine(x2, y2, x3, y3);
			graphics.drawLine(x3, y3, x4, y4);
			graphics.drawLine(x4, y4, x1, y1);
			graphics.popState();
		}
	}

}
