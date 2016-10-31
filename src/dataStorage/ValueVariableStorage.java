package dataStorage;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class ValueVariableStorage {
    private static final double DEFAULT_RETURN = 0;
    private Map<String, Double> variableMap;
    private ObservableList<String> variableList;

    public ValueVariableStorage() {
        variableMap = new HashMap<>();
        variableList = FXCollections.observableArrayList();
    }

    public void setVariable (String varName, Double value) {
        int index = variableList.size();
        if (variableMap.containsKey(varName)) {
            for (int i = 0; i < variableList.size(); i++) {
                if(variableList.get(i).split(" ")[0].equals(varName)) {
                    variableList.remove(i);
                    index = i;
                    break;
                }
            }
        }
        variableMap.put(varName, value);
        variableList.add(index, varName + " " + value);
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

    public Map<String, Double> getVariableMap() {
        return variableMap;
    }
}
