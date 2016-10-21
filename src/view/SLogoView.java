package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import view.element.ViewElement;

import java.util.List;

/**
 * Class responsible for organizing the layout of the GUI, as well as the interactions between
 * various elements.
 */
public class SLogoView {
    private Scene myScene;
    private Parent root;
    private LayoutManager myLayoutManager;
    private List<ViewElement> myViewElements;
    private double myWidth, myHeight;

    public SLogoView() {
        myLayoutManager = new LayoutManager();
        root = myLayoutManager.getElementLayout();
        myWidth = myLayoutManager.getWidth();
        myHeight = myLayoutManager.getHeight();

        myScene = new Scene(root, myWidth, myHeight);

        myViewElements = myLayoutManager.getViewElements();
    }

    public Scene getScene() {
        return myScene;
    }
    public List<ViewElement> getViewElements() {
        return myViewElements;
    }
}
