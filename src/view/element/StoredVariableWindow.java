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
public class StoredVariableWindow implements ViewElement {
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
    }

    public void setStoredVariableList(ObservableList<String> observableFunctionList) {
        storedVariableView.setItems(observableFunctionList);
    }

    public void setClickEvent(EventHandler<MouseEvent> mouseEvent) {
        storedVariableView.setOnMouseClicked(mouseEvent);
    }

    public String getSelectedVariable() {
        return storedVariableView.getFocusModel().getFocusedItem();
    }

    @Override
    public Node getContent() {
        return storedVariableView;
    }
}