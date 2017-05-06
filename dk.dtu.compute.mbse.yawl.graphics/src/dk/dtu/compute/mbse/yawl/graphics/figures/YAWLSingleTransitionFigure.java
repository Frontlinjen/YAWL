package dk.dtu.compute.mbse.yawl.graphics.figures;
 
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;
 
public class YAWLSingleTransitionFigure extends TransitionFigure{
   
	TType type;
	
    public YAWLSingleTransitionFigure(Transition transition) {
        super(transition);
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
    protected void fillShape(Graphics graphics){
        super.fillShape(graphics);
        graphics.pushState();
        
        Rectangle rectangle = this.getClientArea();
        
        Display display = Display.getCurrent();
        Color white = display.getSystemColor(SWT.COLOR_WHITE);
		graphics.setBackgroundColor(white);
		graphics.setLineWidth(1);
        
        graphics.pushState();
       
        int x1 = rectangle.x;
		int y1 = rectangle.y;
		int x2 = x1 + rectangle.width;
		int y2 = y1;
		int x3 = x2;
		int y3 = y1 + rectangle.height;
		int x4 = x1;
		int y4 = y3;
		graphics.drawLine(x1, y1, x2, y2);
		graphics.drawLine(x2, y2, x3, y3);
		graphics.drawLine(x3, y3, x4, y4);
		graphics.drawLine(x1, y1, x4, y4);
        graphics.popState();
    }
   
}