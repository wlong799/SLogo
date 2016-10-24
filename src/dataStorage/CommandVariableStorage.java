package dataStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandVariableStorage {
    private Map<String, List<String>> commandParamMap = new HashMap<String, List<String>>();
    private Map<String, String> commandMap = new HashMap<String, String>();

    public void setCommand (String commandName, String commandString) {
        commandMap.put(commandName, commandString);
    }

    public String getCommand (String commandName) {
        return commandMap.get(commandName);
    }
    
    public List<String> getCommandParams (String commandName) {
        return commandParamMap.get(commandName);
    }
}
