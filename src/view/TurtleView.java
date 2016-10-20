package view;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TurtleView implements ViewElement{
    private Canvas myCanvas;

    public TurtleView() {
        myCanvas = new Canvas(1000, 750);
        GraphicsContext graphics = myCanvas.getGraphicsContext2D();
        graphics.setFill(Color.BLACK);
        graphics.fillRect(0, 0, 1000, 750);
    }

    @Override
    public Node getContent() {
        return myCanvas;
    }
}
