package dataStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandVariableStorage {
    private Map<String, List<String>> commandParamMap;
    private Map<String, String> commandMap;
    private ObservableList<String> commandStorageList;

    public CommandVariableStorage() {
        commandParamMap = new HashMap<>();
        commandMap = new HashMap<>();
        commandStorageList = FXCollections.observableArrayList();
    }

    public void setCommand (String commandName, String commandString) {
        commandStorageList.add(commandName + ":\n" + commandString);
        commandMap.put(commandName, commandString);
    }

    public String getCommand (String commandName) {
        return commandMap.get(commandName);
    }
    
    public List<String> getCommandParams (String commandName) {
        return commandParamMap.get(commandName);
    }

    public ObservableList<String> getCommandVariableList() {
        return commandStorageList;
    }
}
