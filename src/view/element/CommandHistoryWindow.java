package view.element;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class CommandHistoryWindow implements Viewable {
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
        commandListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void setCommandHistory(ObservableList<String> observableCommandHistory) {
        commandListView.setItems(observableCommandHistory);
    }

    public void setClickEvent(EventHandler<MouseEvent> mouseEvent) {
        commandListView.setOnMouseClicked(mouseEvent);
    }

    public String getSelectedCommand() {
        return commandListView.getFocusModel().getFocusedItem();
    }

    @Override
    public Node getContent() {
        return commandListView;
    }
}
