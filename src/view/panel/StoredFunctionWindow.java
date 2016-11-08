package view.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.TextFieldListCell;
import view.Commander;

/**
 * Displays all current functions within the environment. Clicking on a function allows you to enter the parameters you
 * want to submit to it, and then pressing enter will submit that function with the parameters specified.
 *
 * @author Will Long
 */
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

    /**
     * Submit the currently selected function, with the written parameters.
     *
     * @param eventHandler is how the event should be handled upon trigger.
     */
    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        myListView.setOnEditCommit(event -> {
            tempParamStorage = event.getNewValue();
            eventHandler.handle(new ActionEvent());
        });
    }

    /**
     * Gets parameters that were written to be sent with function, and submits it.
     *
     * @param language is the language to send the command in.
     * @return String commanding function with user-specified parameters.
     */
    @Override
    public String getCommandText(String language) {
        String text = myListView.getSelectionModel().getSelectedItem();
        if (text == null) {
            return null;
        }
        String commandName = text.split("\n")[0];
        return commandName + " " + tempParamStorage;
    }

    @Override
    public boolean storeHistory() {
        return false;
    }
}
