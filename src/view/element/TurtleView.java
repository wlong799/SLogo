package view.element;

import dataStorage.TurtleState;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TurtleView implements ViewElement, Observer {
    private static final Color DEFAULT_BG_COLOR = Color.WHITE;
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;
    private static final String TURTLE_IMAGE_LOCATION = "resources/turtle.png";
    private static final double TURTLE_SIZE = 50;

    private double myWidth, myHeight;
    private TurtleState prevState, currentState;
    private StackPane myContent;
    private Rectangle background;
    private Canvas lineCanvas;
    private GraphicsContext lineGraphics;
    private ImageView turtle;

    public TurtleView(double x, double y, double width, double height) {
        myWidth = width;
        myHeight = height;

        background = new Rectangle(width, height, DEFAULT_BG_COLOR);
        lineCanvas = new Canvas(width, height);
        lineGraphics = lineCanvas.getGraphicsContext2D();
        turtle = new ImageView(new Image(TURTLE_IMAGE_LOCATION));
        turtle.setFitHeight(TURTLE_SIZE);
        turtle.setFitWidth(TURTLE_SIZE);

        lineGraphics.setStroke(DEFAULT_LINE_COLOR);
        lineGraphics.strokeLine(0, 0, 100, 100);
        lineGraphics.strokeLine(30, 60, 100, 500);
        lineGraphics.strokeLine(40, 90, 30, 20);


        myContent = new StackPane();
        myContent.setLayoutX(x);
        myContent.setLayoutY(y);
        myContent.getChildren().addAll(background, lineCanvas, turtle);
    }

    @Override
    public Node getContent() {
        return myContent;
    }

    @Override
    public void update(Observable o, Object arg) {
        prevState = currentState;
        currentState = (TurtleState)arg;
        draw();
        return;
    }

    private void draw() {
        System.out.println(currentState.getPosition().getX());
        System.out.println(currentState.getPosition().getY());
        turtle.setTranslateX(currentState.getPosition().getX());
        turtle.setTranslateY(currentState.getPosition().getY());
    }
}
