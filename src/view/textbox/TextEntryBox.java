package view.textbox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CommandParser;
import view.Commander;
import view.GUIElement;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TextEntryBox extends GUIElement implements Commander {
    private static final double TEXT_BOX_RATIO = 0.80;
    private static final double PADDING_RATIO = 0.05;
    private static final String SUBMIT_TEXT = "SUBMIT";
    private static final String CLEAR_TEXT = "CLEAR";

    private HBox myContent;
    private TextArea myTextBox;
    private Button mySubmitButton, myClearButton;

    public TextEntryBox(double width, double height) {
        super(width, height);
        double xPadding = width * PADDING_RATIO;
        double yPadding = height * PADDING_RATIO;

        myContent = new HBox(xPadding);
        myContent.setPrefWidth(width);
        myContent.setPrefHeight(height);

        double textBoxWidth = width * TEXT_BOX_RATIO;
        myTextBox = new TextArea();
        myTextBox.setPrefWidth(textBoxWidth);
        myTextBox.setPrefHeight(height);

        double buttonWidth = width - textBoxWidth - xPadding;
        double buttonHeight = height - yPadding;
        VBox buttonBox = new VBox(yPadding);
        buttonBox.setPrefWidth(buttonWidth);
        buttonBox.setPrefHeight(height);

        mySubmitButton = new Button(SUBMIT_TEXT);
        mySubmitButton.setPrefWidth(buttonWidth);
        mySubmitButton.setPrefHeight(buttonHeight);

        myClearButton = new Button(CLEAR_TEXT);
        myClearButton.setPrefWidth(buttonWidth);
        myClearButton.setPrefHeight(buttonHeight);
        myClearButton.setOnAction(event -> clearText());
        buttonBox.getChildren().addAll(mySubmitButton, myClearButton);

        myContent.getChildren().addAll(myTextBox, buttonBox);
    }

    @Override
    public Node getContent() {
        return myContent;
    }

    public void setSubmitHandler(EventHandler<ActionEvent> submitHandler) {
        mySubmitButton.setOnAction(submitHandler);
    }

    public String getEnteredText() {
        return myTextBox.getText();
    }

    public void setText(String text) {
        myTextBox.setText(text);
    }

    private void clearText() {
        myTextBox.clear();
    }

    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        mySubmitButton.setOnAction(eventHandler);
    }

    @Override
    public String getCommandText(String language) {
        String entryText = myTextBox.getText().trim();
        if (entryText == null || entryText.length() == 0) {
            return null;
        }
        return entryText;
    }

    @Override
    public boolean storeHistory() {
        return true;
    }
}
