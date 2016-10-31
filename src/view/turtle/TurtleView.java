package view.turtle;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import view.GUIElement;
import view.Style;
import view.Stylizable;

/**
 * Represents a turtle object on screen.
 */
public class TurtleView extends GUIElement implements Stylizable{
    private static final String TURTLE_IMAGE_LOCATION = "resources/turtle.png";
    private static final double TURTLE_SIZE = 50;

    private ImageView myTurtle;
    private Image currentImage;

    public TurtleView() {
        super(TURTLE_SIZE, TURTLE_SIZE);
        currentImage = new Image(TURTLE_IMAGE_LOCATION);
        myTurtle = new ImageView(currentImage);
        myTurtle.setFitWidth(myWidth);
        myTurtle.setFitHeight(myHeight);
    }

    @Override
    public void setStyle(Style style) {
        Image img = style.getImage();
        if (img != null) {
            myTurtle.setImage(img);
        }
    }

    @Override
    public Node getContent() {
        return myTurtle;
    }

    public void animatePosition(double x, double y, double timeMillis) {
        if (Math.abs(x - getX()) < 1 && Math.abs(y - getY()) < 1) {
            return;
        }
        MoveTo moveTo = new MoveTo(getX() + myWidth / 2, getY() + myHeight / 2);
        LineTo lineTo = new LineTo(x + myWidth / 2, y + myHeight / 2);
        Path path = new Path(moveTo, lineTo);
        new PathTransition(Duration.millis(timeMillis), path, myTurtle).play();
    }

    public void animateVisibility(boolean visible, double timeMillis) {
        if ((visible && myTurtle.getOpacity() == 1.0) || (!visible && myTurtle.getOpacity() == 0.0)) {
            return;
        }
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(timeMillis), myTurtle);
        fadeTransition.setFromValue(myTurtle.getOpacity());
        fadeTransition.setToValue(visible ? 1.0 : 0.0);
        fadeTransition.play();
    }

    public void animateHeading(double heading, double timeMillis) {
        if (heading + 90 == myTurtle.getRotate()) {
            return;
        }
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(timeMillis), myTurtle);
        rotateTransition.setByAngle((heading + 90) - myTurtle.getRotate());
        rotateTransition.play();
    }

    public double getX() {
        return myTurtle.getTranslateX();
    }

    public double getY() {
        return myTurtle.getTranslateY();
    }
}
