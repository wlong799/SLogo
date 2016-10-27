package view;

import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * Class responsible for organizing the layout of the GUI, as well as the interactions between
 * various elements.
 */
public class SLogoView {
    private double myWidth, myHeight;

    private Scene myScene;
    private ContentManager myCurrentContentManager;
    private ViewElementManager myViewElements;

    public SLogoView(double width, double height) {
        myWidth = width;
        myHeight = height;
        myScene = new Scene(new Group(), myWidth, myHeight);
    }

    public Scene getScene() {
        return myScene;
    }

    public ViewElementManager getViewElements() {
        return myViewElements;
    }

    public double getWidth() {
        return myWidth;
    }

    public double getHeight() {
        return myHeight;
    }

    public void setCurrentContentManager(ContentManager contentManager) {
        myCurrentContentManager = contentManager;
        myScene.setRoot(myCurrentContentManager.getContentLayout());
        myViewElements = myCurrentContentManager.getElements();
    }
}
