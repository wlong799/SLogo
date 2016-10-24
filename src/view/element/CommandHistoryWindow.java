package view.element;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.CommandParser;
import view.element.ViewElement;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class CommandHistoryWindow implements ViewElement {
    private ListView<String> commandListView;

    private double myWidth, myHeight;

    public CommandHistoryWindow(double width, double height) {
        myWidth = width;
        myHeight = height;

        initializeCommandWindow();
    }

    private void initializeCommandWindow() {
        commandListView = new ListView<>();
        commandListView.setPrefWidth(myWidth);
        commandListView.setPrefHeight(myHeight);
    }

    public void setCommandHistory(ObservableList<String> observableCommandHistory) {
        commandListView.setItems(observableCommandHistory);
    }

    @Override
    public Node getContent() {
        return commandListView;
    }
}
