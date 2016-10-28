package dataStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;


public class DataStorageManager {
    // private int simulationID;
    // private static final int DEFAULT_SIM_ID = 0; // default simulation when starting
    // private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandVariableStorage myCommandVariableStorage;
    private Notifications myNotifications;
    private static DataStorageManager instance = new DataStorageManager();

    public DataStorageManager () {
        myValueVariableStorage = new ValueVariableStorage();
        myCommandVariableStorage = new CommandVariableStorage();
        myCommandHistoryStorage = new CommandHistoryStorage();
        myNotifications = new Notifications();
    }

    public Double getVariable (String varName) {
        return myValueVariableStorage.getVariable(varName);
    }

    public void setVariable (String varName, double value) {
        myValueVariableStorage.setVariable(varName, value);
    }

    public void setCommand (String commandName, List<String> parameterNames, String commandString) {
        myCommandVariableStorage.setCommand(commandName, parameterNames, commandString);
    }

    public ObservableList<String> getVariableList () {
        return myValueVariableStorage.getVariableList();
    }

    public boolean hasCommand (String command) {
        return myCommandVariableStorage.hasCommand(command);
    }

    public ObservableList<String> getCommandList () {
        return myCommandVariableStorage.getCommandVariableList();
    }

    public ObservableList<String> getHistoryList () {
        return myCommandHistoryStorage.getCommandHistoryList();
    }
    public void addHistory(String command){
        myCommandHistoryStorage.addCommand(command);
    }
    public static DataStorageManager get () {
        return instance;
    }

}
