package view.element;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class StoredVariableWindow implements Viewable {
    private ListView<String> storedVariableView;

    private double myWidth, myHeight;

    public StoredVariableWindow(double width, double height) {
        myWidth = width;
        myHeight = height;

        initializeFunctionWindow();
    }
    private void initializeFunctionWindow() {
        storedVariableView = new ListView<>();
        storedVariableView.setPrefWidth(myWidth);
        storedVariableView.setPrefHeight(myHeight);
        storedVariableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        storedVariableView.setCellFactory(TextFieldListCell.forListView());
        storedVariableView.setEditable(true);
    }

    public void setStoredVariableList(ObservableList<String> observableFunctionList) {
        storedVariableView.setItems(observableFunctionList);
    }

    public void setClickEvent(EventHandler<MouseEvent> mouseEvent) {
        storedVariableView.setOnMouseClicked(mouseEvent);
    }

    public String getSelectedVariable() {
        return storedVariableView.getSelectionModel().getSelectedItem();
    }

    public void editSelectedVariable() {
        int index = storedVariableView.getSelectionModel().getSelectedIndex();
        storedVariableView.edit(index);
    }

    public void setEditedEvent(EventHandler<ListView.EditEvent<String>> editedEvent) {
        storedVariableView.setOnEditCommit(editedEvent);
    }

    @Override
    public Node getContent() {
        return storedVariableView;
    }
}