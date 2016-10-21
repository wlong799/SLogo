package view.element;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.CommandParser;
import view.element.ViewElement;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class CommandHistoryWindow implements ViewElement {
    private double myWidth, myHeight;

    public CommandHistoryWindow(double width, double height) {
        myWidth = width;
        myHeight = height;
    }

    @Override
    public Node getContent() {
        return new Rectangle(myWidth, myHeight, Color.RED);
    }
}
