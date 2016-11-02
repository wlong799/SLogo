package view.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CommandHistoryWindow extends TabElement {
    private static final String MY_NAME = "History";

    public CommandHistoryWindow(double width, double height) {
        super(width, height);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }

    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        return;
    }

    @Override
    public String getCommandText(String language) {
        return null;
    }

    @Override
    public boolean storeHistory() {
        return false;
    }
}
