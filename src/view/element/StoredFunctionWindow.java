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
public class StoredFunctionWindow implements ViewElement {
    private ListView<String> storedFunctionView;

    private double myWidth, myHeight;

    public StoredFunctionWindow(double width, double height) {
        myWidth = width;
        myHeight = height;

        initializeFunctionWindow();
    }
    private void initializeFunctionWindow() {
        storedFunctionView = new ListView<>();
        storedFunctionView.setPrefWidth(myWidth);
        storedFunctionView.setPrefHeight(myHeight);
        storedFunctionView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void setStoredFunctionList(ObservableList<String> observableFunctionList) {
        storedFunctionView.setItems(observableFunctionList);
    }

    public void setClickEvent(EventHandler<MouseEvent> mouseEvent) {
        storedFunctionView.setOnMouseClicked(mouseEvent);
    }

    public String getSelectedFunction() {
        return storedFunctionView.getFocusModel().getFocusedItem();
    }

    @Override
    public Node getContent() {
        return storedFunctionView;
    }
}