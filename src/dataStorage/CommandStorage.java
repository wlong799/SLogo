package dataStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This class is used to store all of the custom user commands that have been defined in a specific
 * workspace.
 * 
 * @author Michael Schroeder
 *
 */
public class CommandStorage {

    private Map<String, List<String>> myCommandParamMap;
    private Map<String, String> myCommandMap;
    private ObservableList<String> myCommandStorageList;

    public CommandStorage () {
        myCommandParamMap = new HashMap<String, List<String>>();
        myCommandMap = new HashMap<String, String>();
        myCommandStorageList = FXCollections.observableArrayList();
    }

    /**
     * Add a command to the command map
     * 
     * @param commandName - the name of the command
     * @param parameterNames - the names of the variables to be used as parameters in the command
     * @param commandString - the string representation of the commands to be executed when this
     *        command is called.
     */
    public void setCommand (String commandName, List<String> parameterNames, String commandString) {
        myCommandParamMap.put(commandName, parameterNames);
        myCommandMap.put(commandName, commandString);
        String commandView = commandName + "\n[ ";

        for (String parameterName : parameterNames) {
            commandView += parameterName + " ";
        }
        commandView += "]\n" + commandString;
        myCommandStorageList.add(commandView);
    }

    public String getCommand (String commandName) {
        return myCommandMap.get(commandName);
    }

    public List<String> getCommandParams (String commandName) {
        return myCommandParamMap.get(commandName);
    }

    /**
     * Returns whether or not a command has been created
     * 
     * @param commandName - the command to check for
     * @return - true if it has been created, false otherwise
     */
    public boolean hasCommand (String commandName) {
        return myCommandParamMap.containsKey(commandName) && myCommandMap.containsKey(commandName);
    }

    public ObservableList<String> getCommandVariableList () {
        return myCommandStorageList;
    }

    public Map<String, String> getCommandMap () {
        return myCommandMap;
    }
}
