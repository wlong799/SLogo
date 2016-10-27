package view.start;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.Viewable;


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
