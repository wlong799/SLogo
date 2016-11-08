package view;

import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * Main view class, responsible for managing which content is currently viewed on screen.
 *
 * @author Will Long
 */
public class SLogoView {
    private double myWidth, myHeight;

    private Scene myScene;
    private ContentManager myCurrentContentManager;
    private ElementManager myViewElements;

    /**
     * Initialize a new blank scene of specified size.
     *
     * @param width  is width of scene.
     * @param height is height of scene.
     */
    public SLogoView(double width, double height) {
        myWidth = width;
        myHeight = height;
        myScene = new Scene(new Group(), myWidth, myHeight);
    }

    public Scene getScene() {
        return myScene;
    }

    public ElementManager getViewElements() {
        return myViewElements;
    }

    public double getWidth() {
        return myWidth;
    }

    public double getHeight() {
        return myHeight;
    }

    /**
     * Sets the content manager, and changes the scene to use the content specified by it.
     *
     * @param contentManager is the new ContentManager.
     */
    public void setCurrentContentManager(ContentManager contentManager) {
        myCurrentContentManager = contentManager;
        myScene.setRoot(myCurrentContentManager.getContentLayout());
        myViewElements = myCurrentContentManager.getElements();
    }
}
