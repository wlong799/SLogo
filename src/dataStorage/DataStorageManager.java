package dataStorage;

import javafx.collections.ObservableList;

public class DataStorageManager {
    private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;

    private static DataStorageManager instance = new DataStorageManager();

    private DataStorageManager() {
        myTurtle = new Turtle();
        myValueVariableStorage = new ValueVariableStorage();
        myCommandHistoryStorage = new CommandHistoryStorage();
    }

    public static DataStorageManager get() {
        return instance;
    }

    public Turtle getTurtle() {
        return myTurtle;
    }

    public ValueVariableStorage getValueVariableStorage() {
        return myValueVariableStorage;
    }

    public CommandHistoryStorage getCommandHistoryStorage() {
        return myCommandHistoryStorage;
    }
}
