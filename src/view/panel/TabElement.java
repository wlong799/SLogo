package view.panel;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import view.Commander;
import view.GUIElement;

/**
 * Abstract super class for all elements that can be placed in the helper panel as a tab. Introduces a method for
 * getting the proper name of the tab it resides in. All TabElements have an observable list containing information from
 * the backend, and implement Commander, so that they are able to send information to back-end as well.
 *
 * @author Will Long
 */
public abstract class TabElement extends GUIElement implements Commander {
    protected ListView<String> myListView;

    /**
     * Creates new tab of specified size and allows for single selection of elements within it.
     *
     * @param width  is width of tab.
     * @param height is height of tab.
     */
    public TabElement(double width, double height) {
        super(width, height);
        myListView = new ListView<>();
        myListView.setPrefWidth(myWidth);
        myListView.setPrefHeight(myHeight);
        myListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public abstract String getTabName();

    /**
     * Sets the ObservableList of information to display from  back-end.
     *
     * @param observedList is the ObservableList to display.
     */
    public void setObservedList(ObservableList<String> observedList) {
        myListView.setItems(observedList);
    }

    @Override
    public Node getContent() {
        return myListView;
    }
}
