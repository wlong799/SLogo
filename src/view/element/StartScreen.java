package view.element;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import view.element.Viewable;


/**
 * Starting screen responsible for loading the initial workspace.
 */
public class StartScreen implements Viewable {
    private static final String IMAGE_LOCATION = "resources/slogo.png";

    private double myWidth, myHeight;

    private ImageView mySplashScreen;

    public StartScreen(double width, double height) {
        myWidth =  width;
        myHeight = height;

        mySplashScreen = new ImageView(new Image(IMAGE_LOCATION));
        mySplashScreen.setFitWidth(myWidth);
        mySplashScreen.setFitHeight(myHeight);
    }

    @Override
    public Node getContent() {
        return mySplashScreen;
    }
}
