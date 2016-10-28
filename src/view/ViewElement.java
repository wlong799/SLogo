package view;

import view.Viewable;

/**
 * Abstract class for all other elements in view to inherit from.
 */
public abstract class ViewElement implements Viewable {
    protected double myWidth, myHeight;

    public ViewElement() {
        this(-1, -1);
    }

    public ViewElement(double width, double height) {
        myWidth = width;
        myHeight = height;
    }
}
