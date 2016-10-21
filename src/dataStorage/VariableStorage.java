package dataStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ExpressionNode;


public class VariableStorage {
    private static final Double DEFAULT_RETURN = 0.0;
    private Map<String, Double> variableMap = new HashMap<>();
    private Map<String, String> commandMap = new HashMap<String, String>();
    private Map<String, List<String>> commandParamMap = new HashMap<String, List<String>>();
    
    public void setVariable (String varName, Double value) {
        variableMap.put(varName, value);
    }

    public void setCommand (String commandName, String commandString) {
        commandMap.put(commandName, commandString);
    }

    public String getCommand (String commandName) {
        return commandMap.get(commandName);
    }

    public Double getVariable (String varName) {
        return variableMap.containsKey(varName) ? variableMap.get(varName) : DEFAULT_RETURN;
    }

    public List<String> getCommandParams (String commandName) {
        return commandParamMap.get(commandName);
    }
}
