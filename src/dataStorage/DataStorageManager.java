package dataStorage;

import java.util.HashMap;
import java.util.Map;

public class DataStorageManager {
    private int simulationID;
    private static final int DEFAULT_SIM_ID = 0; // default simulation when starting
    private Map<Integer, SubDataStorageManager> mySubDataStorageManagers;
    private static DataStorageManager instance = new DataStorageManager();

    private DataStorageManager() {
        simulationID = DEFAULT_SIM_ID;
        mySubDataStorageManagers = new HashMap<>();
        SubDataStorageManager defaultSubDataStorageManager = new SubDataStorageManager();
        mySubDataStorageManagers.put(DEFAULT_SIM_ID, defaultSubDataStorageManager);
    }

    public static DataStorageManager get() {
        return instance;
    }

    public void changeSimulation(int newSimulationID) {
        if(!(mySubDataStorageManagers.containsKey(newSimulationID))) {
            SubDataStorageManager newSubDataStorageManager = new SubDataStorageManager();
            mySubDataStorageManagers.put(newSimulationID, newSubDataStorageManager);
        }
        simulationID = newSimulationID;
    }

    public Turtle getTurtle() {
        return mySubDataStorageManagers.get(simulationID).getTurtle();
    }

    public ValueVariableStorage getValueVariableStorage() {
        return mySubDataStorageManagers.get(simulationID).getValueVariableStorage();
    }

    public CommandHistoryStorage getCommandHistoryStorage() {
        return mySubDataStorageManagers.get(simulationID).getCommandHistoryStorage();
    }

    public CommandVariableStorage getCommandVariableStorage() {
        return mySubDataStorageManagers.get(simulationID).getCommandVariableStorage();
    }

    public Notifications getNotifications() {
        return mySubDataStorageManagers.get(simulationID).getNotifications();
    }
}
