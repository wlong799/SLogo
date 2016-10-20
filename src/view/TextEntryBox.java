package view;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TextEntryBox implements ViewElement{
    private TextArea myTextBox;

    public TextEntryBox(double x, double y, double width, double height) {
        myTextBox = new TextArea("ENTER COMMAND");
        myTextBox.setLayoutX(x);
        myTextBox.setLayoutY(y);
        myTextBox.setPrefWidth(width);
        myTextBox.setPrefHeight(height);
    }

    @Override
    public Node getContent() {
        return myTextBox;
    }
}
