package view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Class responsible for organizing the layout of the GUI,
 * as well as the interactions between various elements.
 */
public class SLogoView {
    private static final double DEFAULT_WIDTH = 1000;
    private static final double DEFAULT_HEIGHT = 750;

    private Scene myScene;

    public SLogoView() {
        myScene = new Scene(new GridPane(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Scene getScene() {
        return myScene;
    }
}
