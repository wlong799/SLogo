package dataStorage;

public class DataStorageManager {
    private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandVariableStorage myCommandVariableStorage;

    private static DataStorageManager instance = new DataStorageManager();

    private DataStorageManager() {
        myTurtle = new Turtle();
        myValueVariableStorage = new ValueVariableStorage();
        myCommandVariableStorage = new CommandVariableStorage();

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

    public CommandVariableStorage getCommandVariableStorage() {
        return myCommandVariableStorage;
    }
}
