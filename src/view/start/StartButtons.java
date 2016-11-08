package view.start;

import controller.SLogoController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import view.GUIElement;
import view.WorkspaceInteractor;

/**
 * Creates start buttons for loading and creating new workspaces.
 *
 * @author Will Long
 */
public class StartButtons extends GUIElement implements WorkspaceInteractor {
    private static final double PADDING_RATIO = 0.05;
    private static final double NUM_BUTTONS = 2;
    private static final String NEW_BUTTON_TITLE = "New Workspace";
    private static final String LOAD_BUTTON_TITLE = "Load Workspace";

    private double myPadding;

    private HBox buttonContainer;
    private Button newWorkspaceButton, loadWorkspaceButton;

    /**
     * Creates a New and Load button within specified space.
     *
     * @param width  is width of space to create buttons in.
     * @param height is height of space to create buttons in.
     */
    public StartButtons(double width, double height) {
        super(width, height);
        myPadding = myWidth * PADDING_RATIO;

        buttonContainer = new HBox(myPadding);

        newWorkspaceButton = createButton(NEW_BUTTON_TITLE);
        loadWorkspaceButton = createButton(LOAD_BUTTON_TITLE);
    }

    @Override
    public Node getContent() {
        return buttonContainer;
    }

    private Button createButton(String title) {
        Button button = new Button(title);
        double usableWidth = myWidth - (myPadding * (NUM_BUTTONS - 1));
        button.setPrefWidth(usableWidth / NUM_BUTTONS);
        button.setPrefHeight(myHeight);
        buttonContainer.getChildren().add(button);
        return button;
    }

    /**
     * New workspace button creates new workspace, while load workspace button loads in preferences.
     *
     * @param slogoController is the controller that holds the workspaces to interact with.
     */
    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        newWorkspaceButton.setOnAction(event -> slogoController.newWorkspace());
        loadWorkspaceButton.setOnAction(event -> slogoController.loadWorkspace());
    }
}
