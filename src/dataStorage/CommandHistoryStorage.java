package dataStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.element.CommandHistoryWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will Long
 * @version 10/23/16
 */
public class CommandHistoryStorage {
    private List<String> commandHistoryList;
    private ObservableList<String> observableCommandHistoryList;

    public CommandHistoryStorage() {
        commandHistoryList = new ArrayList<>();
        commandHistoryList = FXCollections.observableList(commandHistoryList);
    }

    public void addCommand(String command) {
        commandHistoryList.add(command);
    }

    public ObservableList<String> getCommandHistoryList() {
        return observableCommandHistoryList;
    }
}
