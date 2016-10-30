package view.turtle;

import dataStorage.TurtleState;
import javafx.scene.Node;
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
        if (! (arg instanceof TurtleState)) {
            return;
        }
        draw((TurtleState) arg);
    }

    private void draw(TurtleState turtleState) {
        TurtleView turtleView = myTurtleManager.getTurtle(turtleState.getID());
        TurtleLines turtleLines = myTurtleManager.getTurtleLines(turtleState.getID());

        double x1 = turtleView.getX();
        double y1 = turtleView.getY();
        double x2 = turtleState.getPosition().getX();
        double y2 = turtleState.getPosition().getY();

        turtleView.setPosition(x2, y2);
        turtleLines.drawLine(x1, y1, x2, y2);
        turtleView.setTurtleHeading(turtleState.getHeading());
        turtleView.setTurtleVisibility(turtleState.getVisibility());
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
