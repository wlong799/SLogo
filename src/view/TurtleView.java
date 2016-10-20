package view;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TurtleView implements ViewElement {
    private static final Color DEFAULT_BG_COLOR = Color.BLACK;

    private StackPane myContent;
    private Rectangle background;
    private Canvas lineCanvas;
    private GraphicsContext lineGraphics;
    private ImageView turtle;

    private double myWidth, myHeight;


    public TurtleView(double x, double y, double width, double height) {
        myWidth = width;
        myHeight = height;

        background = new Rectangle(width, height, DEFAULT_BG_COLOR);
        lineCanvas = new Canvas(width, height);
        lineGraphics = lineCanvas.getGraphicsContext2D();
        turtle = new ImageView();

        lineGraphics.setFill(Color.YELLOW);
        lineGraphics.fillRect(0, 0, myWidth, myHeight/2);

        myContent = new StackPane();
        myContent.setLayoutX(x);
        myContent.setLayoutY(y);
        myContent.getChildren().addAll(background, lineCanvas, turtle);
    }

    @Override
    public Node getContent() {
        return myContent;
    }
}
