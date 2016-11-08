package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Classes that implement Commander are able to send text commands to the model, and specify whether or not the commands
 * should be tracked in the application history. All view elements that are able to directly communicate with the
 * back-end do so through this interface.
 *
 * @author Will Long
 */
public interface Commander {
    /**
     * Set when the Commander should trigger its command event.
     *
     * @param eventHandler is how the event should be handled upon trigger.
     */
    void setCommandTrigger(EventHandler<ActionEvent> eventHandler);

    /**
     * Gets the command text to be sent to the model for parsing.
     *
     * @param language is the language to send the command in.
     * @return a String corresponding to the command to be parsed.
     */
    String getCommandText(String language);

    /**
     * @return whether or not commands sent should be stored in history by the model.
     */
    boolean storeHistory();
}
