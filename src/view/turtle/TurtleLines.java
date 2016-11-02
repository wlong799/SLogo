package view.turtle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import view.GUIElement;
import view.Style;
import view.Stylizable;

public class TurtleLines extends GUIElement implements Stylizable {
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;
    private static final double DEFAULT_STROKE_SIZE = 1;
    private static final double[] DOT_SIZE = new double[]{2.5, 7.5};
    private static final double DASH_SIZE = 15.0;

    private Canvas myLineCanvas;
    private GraphicsContext myLineGraphics;
    private boolean isPenDown;
    private String myLineType;


    public TurtleLines(double width, double height) {
        super(width, height);
        myLineCanvas = new Canvas(myWidth, myHeight);
        myLineGraphics = myLineCanvas.getGraphicsContext2D();
        myLineGraphics.setStroke(DEFAULT_LINE_COLOR);
        myLineGraphics.setLineWidth(DEFAULT_STROKE_SIZE);
        isPenDown = true;
        myLineType = "Solid";
    }

    @Override
    public void setStyle(Style style) {
        Color color = style.getColor();
        Double width = style.getWidth();
        Boolean bool = style.getPenIsDown();
        String lineType = style.getLineType();
        if (color != null) {
            myLineGraphics.setStroke(color);
        }
        if (width != null) {
            myLineGraphics.setLineWidth(width);
        }
        if (bool != null) {
            isPenDown = bool;
        }
        if (lineType != null) {
            /*if( lineType.equals("Solid")){
        		myLineGraphics.setLineDashes(null);
        		myLineGraphics.setLineDashOffset(0.0);
        		
        	}else if(lineType.equals("Dotted")){
        		myLineGraphics.setLineDashes(100.0);
        		myLineGraphics.setLineDashOffset(1);
        		
        	}else{
        		myLineGraphics.setLineDashes(DASH_SIZE);
        		myLineGraphics.setLineDashOffset(5);
        		
        		
        	}*/

            myLineType = lineType;
        }
    }

    @Override
    public Node getContent() {
        return myLineCanvas;
    }

    public boolean getIsPenDown() {
        return isPenDown;
    }

    public String getMyLineType() {
        return myLineType;
    }

    public void clearLines() {
        myLineGraphics.clearRect(0, 0, myWidth, myHeight);
    }
    public void drawLine(double x1, double y1, double x2, double y2) {
        myLineGraphics.strokeLine(x1, y1, x2, y2);

    }
}
