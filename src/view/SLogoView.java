package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for organizing the layout of the GUI,
 * as well as the interactions between various elements.
 */
public class SLogoView {
    private static final double DEFAULT_WIDTH = 1000;
    private static final double DEFAULT_HEIGHT = 750;

    private Scene myScene;
    private Parent root;
    private LayoutManager myLayoutManager;
    private List<ViewElement> myViewElements;

    public SLogoView() {
        myLayoutManager = new SimpleLayout();
        myViewElements = new ArrayList<>();
        myViewElements.add(new TurtleView());
        myViewElements.add(new TextEntryBox());

        root = myLayoutManager.setComponentLayout(myViewElements);

        myScene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Scene getScene() {
        return myScene;
    }
}
