package view.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;

import java.util.ResourceBundle;

public class StoredVariableWindow extends TabElement {
    private static final String MY_NAME = "Variables";
    private double tempVal;

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

    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        myListView.setOnEditCommit(event -> {
            tempVal = Double.parseDouble(event.getNewValue());
            eventHandler.handle(new ActionEvent());
        });
    }

    @Override
    public String getCommandText(String language) {
        String text = myListView.getSelectionModel().getSelectedItem();
        if (text == null) {
            return null;
        }
        String variableName = text.split("\\s")[0];
        String setCommand = ResourceBundle.getBundle("resources/languages/" + language).getString("MakeVariable");
        if (setCommand.contains("|")) {
            setCommand = setCommand.split("\\|")[0];
        }
        return setCommand + " " + variableName + " " + tempVal;
    }

    @Override
    public boolean storeHistory() {
        return false;
    }
}
