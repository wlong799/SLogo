package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Classes implementing commander are able to send commands to model to be parsed.
 */
public interface Commander {
    void setCommandTrigger(EventHandler<ActionEvent> eventHandler);
    String getCommandText(String language);
    boolean storeHistory();
}
