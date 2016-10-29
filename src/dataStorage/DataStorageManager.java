package dataStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;


public class DataStorageManager {

    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandVariableStorage myCommandVariableStorage;
    private Notifications myNotifications;

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

    public String getCommand (String command) {
        return myCommandVariableStorage.getCommand(command);
    }

    public List<String> getCommandParams (String command) {
        return myCommandVariableStorage.getCommandParams(command);
    }

    public ObservableList<String> getCommandList () {
        return myCommandVariableStorage.getCommandVariableList();
    }

    public ObservableList<String> getHistoryList () {
        return myCommandHistoryStorage.getCommandHistoryList();
    }

    public void addHistory (String command) {
        myCommandHistoryStorage.addCommand(command);
    }
}
