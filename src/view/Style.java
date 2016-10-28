package view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Style class allows for elements in the view to set the style of each other. The class setting the style will
 * instantiate a new Style object with the necessary parameters, and then send it to the class to be styled.
 */
public class Style {
    private Image myImage;
    private Color myColor;

    public Style(Image img) {
        myImage = img;
    }

    public Style(Color color) {
        myColor = color;
    }

    public Image getImage() {
        return myImage;
    }

    public Color getColor() {
        return myColor;
    }
}
