package view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;


/**
 * Style class provides a way for elements in the view to set the style of each other. The class setting the style can
 * instantiate a new Style object with the necessary parameters, and then send it to the class to be styled. Many
 * different Style constructors are available, reflecting the many different styles that can be set.
 *
 * @author Will Long
 * @author James Marlotte
 */
public class Style {
    private Image myImage;
    private Color myColor;
    private double myLineWidth;
    private boolean myBool;
    private String myLineType;

    public Style(Image img) {
        myImage = img;
    }

    public Style(Color color) {
        myColor = color;
    }

    public Style(double num) {
        myLineWidth = num;
    }

    public Style(boolean bool) {
        myBool = bool;
    }

    public Style(String line) {
        myLineType = line;
    }

    public Image getImage() {
        return myImage;
    }

    public Color getColor() {
        return myColor;
    }

    public boolean getPenIsDown() {
        return myBool;
    }

    public double getWidth() {
        return myLineWidth;
    }

    public String getLineType() {
        return myLineType;
    }
}
