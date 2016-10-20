package view;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TurtleView implements ViewElement {
    private static final Color DEFAULT_BG_COLOR = Color.WHITE;
    private static final String TURTLE_IMAGE_LOCATION = "resources/turtle.png";
    private static final double TURTLE_SIZE = 50;

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
        turtle = new ImageView(new Image("resources/turtle2.png"));
        turtle.setFitHeight(TURTLE_SIZE);
        turtle.setFitWidth(TURTLE_SIZE);

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
