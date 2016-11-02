package view.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.TextFieldListCell;
import view.Commander;

public class StoredFunctionWindow extends TabElement {
    private static final String MY_NAME = "Functions";
    private String tempParamStorage;

    public StoredFunctionWindow(double width, double height) {
        super(width, height);
        myListView.setCellFactory(TextFieldListCell.forListView());
        myListView.setEditable(true);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }

    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        myListView.setOnEditCommit(event -> {
            tempParamStorage = event.getNewValue();
            eventHandler.handle(new ActionEvent());
        });
    }

    @Override
    public String getCommandText(String language) {
       String text = myListView.getSelectionModel().getSelectedItem();
        if (text == null) {
            return null;
        }
        String commandName = text.split("\n")[0];
        return commandName + " "+ tempParamStorage;
    }

    @Override
    public boolean storeHistory() {
        return false;
    }
}