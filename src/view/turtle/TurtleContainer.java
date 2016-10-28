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
    private TurtleLines myTurtleLines;
    private TurtleView myTurtleView;

    public TurtleContainer(double width, double height) {
        super(width, height);
        myContainer = new StackPane();
        myBackground = new Rectangle(width, height, DEFAULT_BG_COLOR);
        myContainer.getChildren().add(myBackground);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (currentState != null) {
            prevState = currentState;
        } else {
            prevState = (TurtleState) arg;
        }
        currentState = (TurtleState) arg;
        draw();
        return;
    }


    private void draw() {
        double x1 = currentState.getPosition().getX();
        double y1 = currentState.getPosition().getY();
        double x2 = prevState.getPosition().getX();
        double y2 = prevState.getPosition().getY();
        if (x1 != x2 || y1 != y2) {
            updateTurtlePosition(x1, y1);
            if (currentState.getPenDownStatus()) {
                drawLine(x1, y1, x2, y2);
            }
        }

        updateTurtleHeading(currentState.getHeading());
        updateTurtleVisibility(currentState.getVisibility());
    }

    private void updateTurtlePosition(double x, double y) {
        myTurtleView.getContent().setTranslateX(x);
        myTurtleView.getContent().setTranslateY(y);
    }

    private void drawLine(double x1, double y1, double x2, double y2) {
        //myLineGraphics.strokeLine(x1 + myWidth / 2, y1 + myHeight / 2,
          //      x2 + myWidth / 2, y2 + myHeight / 2);
    }

    private void updateTurtleHeading(double heading) {
        //turtle.setRotate(heading + 90);
    }


    private void updateTurtleVisibility(boolean isVisible) {
        //turtle.setVisible(isVisible);
    }

    public void setTurtleImage(String picture_file_path) {
        Style s = new Style(new Image(picture_file_path));
        myTurtleView.setStyle(s);
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
}
