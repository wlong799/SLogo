package view;

/**
 * Abstract super class for all elements within main GUI to inherit from. Implements Viewable so that all subclasses
 * have a getContent method to return a JavaFX node.
 *
 * @author Will Long
 */
public abstract class GUIElement implements Viewable {
    protected double myWidth, myHeight;

    public GUIElement() {
        this(-1, -1);
    }

    public GUIElement(double width, double height) {
        myWidth = width;
        myHeight = height;
    }

    public double getWidth() {
        return myWidth;
    }

    public double getHeight() {
        return myHeight;
    }

}
