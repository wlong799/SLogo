package view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;


/**
 * Style class allows for elements in the view to set the style of each other. The class setting the
 * style will
 * instantiate a new Style object with the necessary parameters, and then send it to the class to be
 * styled.
 */
public class Style {
    private Image myImage;
    private Color myColor;
    private double myLineWidth;
    private boolean myBool;

    public Style (Image img) {
        myImage = img;
    }

    public Style (Color color) {
        myColor = color;
    }
    
    public Style (double num){
    	myLineWidth = num;
    }
    
    public Style(boolean bool){
    	myBool = bool;
    	
    }

    public Image getImage () {
        return myImage;
    }

    public Color getColor () {
        return myColor;
    }
    
    public boolean getPenIsDown (){
    	return myBool;
    }
    
    public double getWidth(){
    	return myLineWidth;
    }
}
