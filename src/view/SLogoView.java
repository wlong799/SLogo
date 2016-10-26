package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import view.element.Viewable;

import java.util.List;

/**
 * Class responsible for organizing the layout of the GUI, as well as the interactions between
 * various elements.
 */
public class SLogoView {
    private static final double DEFAULT_WIDTH = 1000;
    private static final double DEFAULT_HEIGHT = 750;

    private double myWidth, myHeight;

    private Scene myScene;
    private ContentManager myCurrentContentManager;
    private List<Viewable> myViewables;

    public SLogoView() {
        myWidth = DEFAULT_WIDTH;
        myHeight = DEFAULT_HEIGHT;

        myCurrentContentManager = new StartContent(myWidth, myHeight);
        myViewables = myCurrentContentManager.getElements();

        myScene = new Scene(myCurrentContentManager.getContentLayout(), myWidth, myHeight);
    }

    public Scene getScene() {
        return myScene;
    }

    public List<Viewable> getViewElements() {
        return myViewables;
    }

    public void setCurrentContentManager(ContentManager contentManager) {
        myCurrentContentManager = contentManager;
        myScene.setRoot(myCurrentContentManager.getContentLayout());
        myViewables = myCurrentContentManager.getElements();
    }
}
