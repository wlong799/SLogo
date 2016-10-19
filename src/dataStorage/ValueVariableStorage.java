package dataStorage;

import java.util.HashMap;
import java.util.Map;


public class ValueVariableStorage {
    private static final double DEFAULT_RETURN = 0;
    private Map<String, Double> variableMap = new HashMap<>();

    public void setVariable(String varName, double value) {
        variableMap.put(varName, value);
    }

    public boolean variableExists(String varName) {
        return variableMap.containsKey(varName);
    }

    public Double getVariable(String varName) {
        return variableExists(varName) ? variableMap.get(varName) : DEFAULT_RETURN;
    }
}
