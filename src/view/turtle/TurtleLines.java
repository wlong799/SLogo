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
    private static final double[] DOT_SIZE = new double[] {2.5, 7.5};
    private static final double DASH_SIZE = 15.0;

    private Canvas myLineCanvas;
    private GraphicsContext myLineGraphics;

    public TurtleLines(double width, double height) {
        super(width, height);
        myLineCanvas = new Canvas(myWidth, myHeight);
        myLineGraphics = myLineCanvas.getGraphicsContext2D();
        myLineGraphics.setStroke(DEFAULT_LINE_COLOR);
        myLineGraphics.setLineWidth(DEFAULT_STROKE_SIZE);
    }

    @Override
    public void setStyle(Style style) {
        Color color = style.getColor();
        if (color != null) {
            myLineGraphics.setStroke(color);
        }
    }

    @Override
    public Node getContent() {
        return myLineCanvas;
    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        myLineGraphics.strokeLine(x1, y1, x2, y2);
    }
}
