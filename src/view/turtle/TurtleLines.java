package view.turtle;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import view.GUIElement;
import view.Style;
import view.Stylizable;

/**
 * Provides a canvas on which to draw lines. Allows for stylizable line types, colors, and sizes.
 *
 * @author Will Long
 * @author James Marlotte
 */
public class TurtleLines extends GUIElement implements Stylizable {
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;
    private static final double DEFAULT_STROKE_SIZE = 1;
    private static final double[] DOT_SIZE = new double[]{2.5, 7.5};
    private static final double DASH_SIZE = 15.0;

    private Canvas myLineCanvas;
    private GraphicsContext myLineGraphics;
    private boolean isPenDown;
    private String myLineType;


    /**
     * Creates new canvas of specified size, and sets default pen settings.
     *
     * @param width  is width of canvas.
     * @param height is height of canvas.
     */
    public TurtleLines(double width, double height) {
        super(width, height);
        myLineCanvas = new Canvas(myWidth, myHeight);
        myLineGraphics = myLineCanvas.getGraphicsContext2D();
        myLineGraphics.setStroke(DEFAULT_LINE_COLOR);
        myLineGraphics.setLineWidth(DEFAULT_STROKE_SIZE);
        isPenDown = true;
        myLineType = "Solid";
    }

    /**
     * Sets line size, color, or type depending on passed information.
     *
     * @param style is Style object with appearance information.
     */
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
            if (lineType.equals("Solid")) {
                myLineGraphics.setLineDashes(0);

            } else if (lineType.equals("Dotted")) {
                myLineGraphics.setLineDashes(DOT_SIZE);

            } else {
                myLineGraphics.setLineDashes(DASH_SIZE);
            }
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

    /**
     * Clears contents of canvas.
     */
    public void clearLines() {
        myLineGraphics.clearRect(0, 0, myWidth, myHeight);
    }

    /**
     * Draws a line from (x1, y1) to (x2, y2)
     */
    public void drawLine(double x1, double y1, double x2, double y2) {
        myLineGraphics.strokeLine(x1, y1, x2, y2);
    }
}
