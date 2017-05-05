package dk.dtu.compute.mbse.yawl.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import dk.dtu.compute.mbse.yawl.JType;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;

/**
 * 
 * @author Mikkel
 *
 */

public class YAWLJTransitionFigure extends TransitionFigure{

	private TType type;
	
	public YAWLJTransitionFigure(Transition transition) {
		super(transition);
		type = YAWLFunctions.getJoinType((dk.dtu.compute.mbse.yawl.Transition)transition);
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		
		graphics.setLineWidth(1);
		Rectangle rectangle = this.getClientArea();
		int d1 = rectangle.width / 3;
		
		if(type.equals(JType.XOR)){
			graphics.pushState();
			int x1 = rectangle.x + d1;
			int y1 = rectangle.height;
			int x2 = x1;
			int y2 = rectangle.y;
			int x3 = rectangle.x;
			int y3 = rectangle.height / 2;
			graphics.drawPolygon(new int[]{x1,y1, x2,y2, x3,y3});
			graphics.popState();
		}
		
		if(type.equals(JType.AND)){
			graphics.pushState();
			int x11 = d1;
			int y11 = rectangle.height;
			int x21 = x11;
			int y21 = rectangle.y;
			graphics.drawPolygon(new int[]{x11,y11, x21,y21});
			int x1 = rectangle.x;
			int y1 = rectangle.height;
			int x2 = d1;
			int y2 = rectangle.height / 2;
			int x3 = d1;
			int y3 = rectangle.y;
			graphics.drawPolygon(new int[]{x1,y1, x2,y2, x3,y3});
			graphics.popState();
		}
		
		if(type.equals(JType.OR)){
			graphics.pushState();
			int x11 = d1;
			int y11 = rectangle.height;
			int x21 = d1;
			int y21 = rectangle.y;
			graphics.drawPolygon(new int[]{x11,y11, x21,y21});
			int x1 = rectangle.x + (rectangle.width / 6);
			int y1 = rectangle.height;
			int x2 = d1;
			int y2 = rectangle.height / 2;
			int x3 = x1;
			int y3 = rectangle.y;
			int x4 = rectangle.x;
			int y4 = y2;
			graphics.drawPolygon(new int[]{x1,y1, x2,y2, x3,y3, x4,y4});
			graphics.popState();
		}
	}
	


}
