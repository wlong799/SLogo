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
        myListView.setOnMouseClicked(event -> eventHandler.handle(new ActionEvent()));
    }

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
