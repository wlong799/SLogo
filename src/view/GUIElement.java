package view;

/**
 * Abstract class for all other elements in view to inherit from.
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
