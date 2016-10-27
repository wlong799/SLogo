package view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import view.Viewable;

public class StartButtons implements Viewable {
    private static final double PADDING_RATIO = 0.05;
    private static final double NUM_BUTTONS = 2;
    private static final String NEW_BUTTON_TITLE = "New Workspace";
    private static final String LOAD_BUTTON_TITLE = "Load Workspace";

    private double myWidth, myHeight, myPadding;

    private HBox buttonContainer;
    private Button newWorkspaceButton, loadWorkspaceButton;

    public StartButtons(double width, double height) {
        myWidth = width;
        myHeight = height;
        myPadding = width * PADDING_RATIO;

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

    public void setStartEvent(EventHandler<ActionEvent> startEvent) {
        newWorkspaceButton.setOnAction(startEvent);
        loadWorkspaceButton.setOnAction(startEvent);
    }

}
