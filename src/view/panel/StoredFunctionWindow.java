package view.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.Commander;

public class StoredFunctionWindow extends TabElement implements Commander {
    private static final String MY_NAME = "Functions";

    public StoredFunctionWindow(double width, double height) {
        super(width, height);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }

    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        myListView.setOnMouseClicked(event -> eventHandler.handle(new ActionEvent()));
    }

    @Override
    public String getCommandText(String language) {
        return getSelectedElement();
    }

    @Override
    public boolean storeHistory() {
        return false;
    }
}