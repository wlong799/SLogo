package view.turtle;

import dataStorage.Turtle;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import view.GUIElement;
import view.Style;
import view.Stylizable;

public class TurtleLines extends GUIElement implements Stylizable {
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;

    private Canvas myLineCanvas;
    private GraphicsContext myLineGraphics;

    public TurtleLines(double width, double height) {
        super(width, height);
        myLineCanvas = new Canvas(myWidth, myHeight);
        myLineGraphics = myLineCanvas.getGraphicsContext2D();
        myLineGraphics.setStroke(DEFAULT_LINE_COLOR);
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
        myLineGraphics.strokeLine(x1 + myWidth / 2, y1 + myHeight / 2,
                x2 + myWidth / 2, y2 + myHeight / 2);
    }


}
