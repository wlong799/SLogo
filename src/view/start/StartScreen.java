package view.start;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.GUIElement;


/**
 * Starting screen responsible for loading the initial workspace.
 */
public class StartScreen extends GUIElement {
    private static final String IMAGE_LOCATION = "resources/slogo.png";

    private ImageView mySplashScreen;

    public StartScreen(double width, double height) {
        super(width, height);
        mySplashScreen = new ImageView(new Image(IMAGE_LOCATION));
        mySplashScreen.setFitWidth(myWidth);
        mySplashScreen.setFitHeight(myHeight);
    }

    @Override
    public Node getContent() {
        return mySplashScreen;
    }
}
