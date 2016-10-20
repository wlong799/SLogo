package view;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TextEntryBox implements ViewElement{
    private TextArea myTextBox;

    public TextEntryBox() {
        myTextBox = new TextArea("BLEH");
    }

    @Override
    public Node getContent() {
        return myTextBox;
    }
}
