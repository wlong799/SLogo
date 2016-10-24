package dataStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ExpressionNode;



public class ValueVariableStorage {
    private static final double DEFAULT_RETURN = 0;
    private Map<String, Double> variableMap;
    private ObservableList<String> variableList;

    public ValueVariableStorage() {
        variableMap = new HashMap<>();
        variableList = FXCollections.observableArrayList();
    }

    public void setVariable (String varName, Double value) {
        variableMap.put(varName, value);
        variableList.add(varName + ": " + value);
    }

    public boolean variableExists(String varName) {
        return variableMap.containsKey(varName);
    }

    public Double getVariable(String varName) {
        return variableExists(varName) ? variableMap.get(varName) : DEFAULT_RETURN;
    }

    public ObservableList<String> getVariableList() {
        return variableList;
    }
}
