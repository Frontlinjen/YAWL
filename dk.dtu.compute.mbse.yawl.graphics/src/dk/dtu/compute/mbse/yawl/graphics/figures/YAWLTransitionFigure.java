package dk.dtu.compute.mbse.yawl.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;

import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;

/*
 * 
 * @author Sebastian + @coauthor Mikkel
 * 
 */
public class YAWLTransitionFigure extends TransitionFigure {

	TType join;
	TType split;
	
	public YAWLTransitionFigure(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		super(transition);
		UpdateTypes();
	}
	
	private boolean UpdateTypes(){
		TType oldJoin = join;
		TType oldSplit = split;
		join = YAWLFunctions.getJoinType((Transition)transition);
		split = YAWLFunctions.getSplitType((Transition)transition);
		return join != oldJoin || split != oldSplit;
	}
	@Override
	public void update() {
		if(UpdateTypes()){
			repaint();
		}
	}
	
	private void drawLeftPointingTriangle(Graphics graphics, boolean leftSide){
		int offset = 0;
		Rectangle rectangle = getClientArea();

		if(!leftSide){
			offset = (int)((float)rectangle.width * (2f/3f));
		}
		graphics.drawPolygon(new int[]{offset + 0 + rectangle.x, (int)(rectangle.height * 0.5) + rectangle.y,
									   offset + (int)(rectangle.width*(1f/3f)) + rectangle.x, 0 + rectangle.y, 
									   offset + (int)(rectangle.width*(1f/3f)) + rectangle.x, rectangle.height + rectangle.y });
	}
	
	private void drawRightPointingTriangle(Graphics graphics, boolean leftSide){
		int offset = 0;
		Rectangle rectangle = getClientArea();

		if(!leftSide){
			offset = (int)((float)rectangle.width * (2f/3f));
		}
		graphics.drawPolygon(new int[]{offset + 0 + rectangle.x, rectangle.height + rectangle.y, 
							 		   offset + (int)(rectangle.width*(1f/3f)) + rectangle.x, (int)(rectangle.height * 0.5) + rectangle.y, 
							 		   offset + 0 + rectangle.x, rectangle.y + 0});
	}
	
	private void drawDiamond(Graphics graphics, boolean leftSide){
		int offset = 0;
		Rectangle rectangle = getClientArea();

		if(!leftSide){
			offset = (int)((float)rectangle.width * (2f/3f));
		}
		int xOffset = (int)((float)rectangle.width * (1f/6f));
		graphics.drawPolygon(new int[]{xOffset + offset + rectangle.x, 0 + rectangle.y,
										offset + (int)(rectangle.width*(1f/3f)) + rectangle.x, (int)(rectangle.height*0.5) + rectangle.y,
										xOffset + offset + rectangle.x, rectangle.height + rectangle.y, 
										offset + rectangle.x, (int)(rectangle.height*0.5) + rectangle.y});
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		// TODO Auto-generated method stub
		super.fillShape(graphics);
		graphics.pushState();
		Display display = Display.getCurrent();
		Rectangle rectangle = this.getClientArea();
		Color color = display.getSystemColor(SWT.COLOR_GRAY);
		graphics.setLineWidth(1);
		graphics.setBackgroundColor(color);
		if(join != null){
			switch(join){
				case AND:
					drawRightPointingTriangle(graphics, true);
					break;
				case OR:
					drawDiamond(graphics, true);
					break;
				case XOR:
					drawLeftPointingTriangle(graphics, true);
					break;
				default:
				break;
			}
			if(!join.equals(TType.NORMAL)){
				graphics.drawLine((int)(rectangle.width*(1f/3f)) + rectangle.x, 0 + rectangle.y, 
						(int)(rectangle.width*(1f/3f)) + rectangle.x, rectangle.height + rectangle.y);
			}
		}
		if(split != null){
			switch(split){
			case AND:
				drawLeftPointingTriangle(graphics, false);
				break;
			case OR:
				drawDiamond(graphics, false);
				break;
			case XOR:
				drawRightPointingTriangle(graphics, false);
				break;
			default:
				break;
			}
			if(!split.equals(TType.NORMAL)){
				graphics.drawLine((int)(rectangle.width*(2f/3f)) + rectangle.x, rectangle.y, 
						(int)(rectangle.width*(2f/3f)) + rectangle.x, rectangle.height + rectangle.y);
			}
		}
		graphics.popState();
	}
	
}
