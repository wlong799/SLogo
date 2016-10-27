package view.element;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;

public class StoredVariableWindow extends TabElement {
    private static final String MY_NAME = "Variables";

    public StoredVariableWindow(double width, double height) {
        super(width, height);
        myListView.setCellFactory(TextFieldListCell.forListView());
        myListView.setEditable(true);
    }

    public void editSelectedVariable() {
        int index = myListView.getSelectionModel().getSelectedIndex();
        myListView.edit(index);
    }

    public void setEditedEvent(EventHandler<ListView.EditEvent<String>> editedEvent) {
        myListView.setOnEditCommit(editedEvent);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }
}