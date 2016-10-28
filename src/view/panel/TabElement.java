package view.panel;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import view.GUIElement;

/**
 * Abstract super class for all elements that can be placed in the helper panel as a tab. Introduces a method for
 * getting the proper name of the tab it resides in. Elements all
 */
public abstract class TabElement extends GUIElement {
    protected ListView<String> myListView;

    public TabElement(double width, double height) {
        super(width, height);
        myListView = new ListView<>();
        myListView.setPrefWidth(myWidth);
        myListView.setPrefHeight(myHeight);
        myListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public abstract String getTabName();

    public void setObservedList(ObservableList<String> observedList) {
        myListView.setItems(observedList);
    }

    public void setClickEvent(EventHandler<MouseEvent> mouseEventHandler) {
        myListView.setOnMouseClicked(mouseEventHandler);
    }

    public String getSelectedElement() {
        return myListView.getSelectionModel().getSelectedItem();
    }

    @Override
    public Node getContent() {
        return myListView;
    }
}
