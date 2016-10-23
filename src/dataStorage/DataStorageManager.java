package dataStorage;

import dataStorage.ValueVariableStorage;

public class DataStorageManager {
    private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;
    private CommandVariableStorage myCommandVariableStorage;

    private static DataStorageManager instance = new DataStorageManager();

    private DataStorageManager() {
        myTurtle = new Turtle();
        myValueVariableStorage = new ValueVariableStorage();
        myCommandVariableStorage = new CommandVariableStorage();
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

    public CommandVariableStorage getCommandVariableStorage() {
        return myCommandVariableStorage;
    }
}
