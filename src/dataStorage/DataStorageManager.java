package dataStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataStorageManager {
    private int simulationID;
    private static final int DEFAULT_SIM_ID = 0; // default simulation when starting
    private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandVariableStorage myCommandVariableStorage;
    private Notifications myNotifications;
    private static DataStorageManager instance = new DataStorageManager();

    public DataStorageManager () {
        simulationID = DEFAULT_SIM_ID;
        myTurtle = new Turtle();
        myValueVariableStorage = new ValueVariableStorage();
        myCommandVariableStorage = new CommandVariableStorage();
        myCommandHistoryStorage = new CommandHistoryStorage();
        myNotifications = new Notifications();
    }

    public Turtle getTurtle () {
        return myTurtle;
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

    public static DataStorageManager get () {
        return instance;
    }

}
