package dataStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * @author Will Long
 * @version 10/23/16
 */
public class CommandHistoryStorage {
    private ObservableList<String> observableCommandHistoryList;

    public CommandHistoryStorage() {
        observableCommandHistoryList = FXCollections.observableArrayList();
    }

    public void addCommand(String command) {
        observableCommandHistoryList.add(command);
    }

    public ObservableList<String> getCommandHistoryList() {
        return observableCommandHistoryList;
    }
}
