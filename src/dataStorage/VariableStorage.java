package dataStorage;

import java.util.HashMap;
import java.util.Map;


public class VariableStorage {
    private static final double DEFAULT_RETURN = 0;
    private Map<String, Double> variableMap = new HashMap<>();

    public void setVariable(String varName, double value) {
        variableMap.put(varName, value);
    }

    public Double getVariable(String varName) {
        return variableMap.containsKey(varName) ? variableMap.get(varName) : DEFAULT_RETURN;
    }
}