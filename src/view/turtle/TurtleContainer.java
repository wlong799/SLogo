package view.turtle;

import dataStorage.Turtle;
import dataStorage.TurtleState;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GUIElement;
import view.Style;
import view.Stylizable;

import java.util.Observable;
import java.util.Observer;

/**
 * Container for all current turtles and the lines they've drawn
 */
public class TurtleContainer extends GUIElement implements Observer, Stylizable {
    private static final Color DEFAULT_BG_COLOR = Color.WHITE;

    private TurtleState prevState, currentState;
    private StackPane myContainer;
    private Rectangle myBackground;
    private TurtleManager myTurtleManager;

    public TurtleContainer(double width, double height) {
        super(width, height);
        myContainer = new StackPane();
        myBackground = new Rectangle(myWidth, myHeight, DEFAULT_BG_COLOR);
        myTurtleManager = new TurtleManager(myWidth, myHeight);
        myContainer.getChildren().addAll(myBackground, myTurtleManager.getContent());
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        System.out.println(arg);
        if (currentState != null) {
            prevState = currentState;
        } else {
            prevState = (TurtleState) arg;
        }
        currentState = (TurtleState) arg;
        draw();
    }

    private void draw() {
        double x1 = currentState.getPosition().getX();
        double y1 = currentState.getPosition().getY();
        double x2 = prevState.getPosition().getX();
        double y2 = prevState.getPosition().getY();

        TurtleView turtleView = myTurtleManager.getActiveTurtles().get(0);
        TurtleLines turtleLines = myTurtleManager.getActiveTurtleLines().get(0);

        if (x1 != x2 || y1 != y2) {
            turtleView.setPosition(x1, y1);
            if (currentState.getPenDownStatus()) {
                turtleLines.drawLine(x1, y1, x2, y2);
            }
        }

        turtleView.setTurtleHeading(currentState.getHeading());
        turtleView.setTurtleVisibility(currentState.getVisibility());
    }

    @Override
    public void setStyle(Style style) {
        Color color = style.getColor();
        if (color != null) {
            myBackground.setFill(color);
        }
    }

    @Override
    public Node getContent() {
        return myContainer;
    }

    public TurtleManager getTurtleManager() {
        return myTurtleManager;
    }
}
