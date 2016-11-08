package view.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Displays the current history of commands in the environment. Clicking a command will submit it for parsing.
 *
 * @author Will Long
 */
public class CommandHistoryWindow extends TabElement {
    private static final String MY_NAME = "History";

    public CommandHistoryWindow(double width, double height) {
        super(width, height);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }

    /**
     * Submit the clicked command.
     *
     * @param eventHandler is how the event should be handled upon trigger.
     */
    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        myListView.setOnMouseClicked(event -> eventHandler.handle(new ActionEvent()));
    }

    /**
     * Get selected command and submit it, ignoring the original output messages stored with it.
     *
     * @param language is the language to send the command in.
     * @return the String of just the command text.
     */
    @Override
    public String getCommandText(String language) {
        String text = myListView.getSelectionModel().getSelectedItem();
        if (text == null || text.length() == 0) {
            return null;
        }
        String[] arr = myListView.getSelectionModel().getSelectedItem().split("\n");
        if (arr.length == 1) {
            return arr[0];
        }
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sBuilder.append(arr[i]);
        }
        return sBuilder.toString();
    }

    @Override
    public boolean storeHistory() {
        return true;
    }
}
