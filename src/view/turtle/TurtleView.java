package view.turtle;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    public void setPosition(double x, double y) {
        myTurtle.setTranslateX(x);
        myTurtle.setTranslateY(y);
    }

    public void setTurtleHeading(double heading) {
        myTurtle.setRotate(heading + 90);
    }

    public void setTurtleVisibility(boolean isVisible) {
        myTurtle.setVisible(isVisible);
    }
}
