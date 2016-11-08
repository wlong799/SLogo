package view.turtle;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GUIElement;
import view.Style;
import view.Stylizable;

/**
 * Represents a turtle on screen and provides methods for getting/setting its current status. Has ability to change its
 * image.
 */
public class TurtleView extends GUIElement implements Stylizable {
    private static final String TURTLE_IMAGE_LOCATION = "resources/turtle.png";
    private static final double TURTLE_SIZE = 50;
    private static final Color HIGHLIGHT_COLOR = Color.YELLOW;
    private static final double HIGHLIGHT_OPACITY = 0.25;
    private static final double VISIBLE_OPACITY = 1.0;
    private static final double INVISIBLE_OPACITY = 0.0;

    private StackPane myContent;
    private ImageView myTurtle;
    private Rectangle myHighlightBox;
    private Image currentImage;

    /**
     * Creates turtle in center of screen and sets it to have default image and settings.
     */
    public TurtleView() {
        super(TURTLE_SIZE, TURTLE_SIZE);
        currentImage = new Image(TURTLE_IMAGE_LOCATION);
        myTurtle = new ImageView(currentImage);
        myTurtle.setFitWidth(myWidth);
        myTurtle.setFitHeight(myHeight);
        myHighlightBox = new Rectangle(myWidth, myHeight, HIGHLIGHT_COLOR);
        myHighlightBox.setOpacity(HIGHLIGHT_OPACITY);
        myContent = new StackPane(myTurtle, myHighlightBox);
    }

    /**
     * Change image to that specified by Style object.
     *
     * @param style is Style object with appearance information.
     */
    @Override
    public void setStyle(Style style) {
        Image img = style.getImage();
        if (img != null) {
            myTurtle.setImage(img);
        }
    }

    @Override
    public Node getContent() {
        return myContent;
    }

    public double getX() {
        return myContent.getTranslateX();
    }

    public double getY() {
        return myContent.getTranslateY();
    }

    public boolean isVisible() {
        return myContent.getOpacity() == VISIBLE_OPACITY;
    }

    public double getCorrectOpacity(boolean visible) {
        return visible ? VISIBLE_OPACITY : INVISIBLE_OPACITY;
    }

    public double getHeading() {
        return myContent.getRotate();
    }

    public void setActiveStatus(boolean active) {
        if (active) {
            myHighlightBox.setOpacity(HIGHLIGHT_OPACITY);
        } else {
            myHighlightBox.setOpacity(INVISIBLE_OPACITY);
        }
    }
}
