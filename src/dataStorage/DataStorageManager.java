package dataStorage;

import java.util.*;

public class DataStorageManager {
    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandVariableStorage myCommandVariableStorage;
    private Notifications myNotifications;

    private List<Integer> myActiveIDs;
    private static final int DEFAULT_SIM_ID = 1; // default simulation when starting
    private Map<Integer, Turtle> myTurtleStorage;
    private static DataStorageManager instance = new DataStorageManager();

    private DataStorageManager() {
        myValueVariableStorage = new ValueVariableStorage();
        myCommandVariableStorage = new CommandVariableStorage();
        myCommandHistoryStorage = new CommandHistoryStorage();
        myNotifications = new Notifications();

        Turtle defaultTurtle = new Turtle(DEFAULT_SIM_ID);
        myTurtleStorage.put(DEFAULT_SIM_ID, defaultTurtle);

        myActiveIDs = new ArrayList<>();
        myActiveIDs.add(DEFAULT_SIM_ID);
    }

    public static DataStorageManager get() {
        return instance;
    }

    public void changeSimulation(List<Integer> newSimulationIDs) {
        myActiveIDs.clear();
        for(int oneID : newSimulationIDs) {
            if(!(myTurtleStorage.containsKey(oneID))) {
                myTurtleStorage.put(oneID, new Turtle(oneID));
            }
        }
        myActiveIDs = newSimulationIDs;
    }

    public Collection<Turtle> getActiveTurtles() {
        return myTurtleStorage.values();
    }

    public ValueVariableStorage getValueVariableStorage() {
        return myValueVariableStorage;
    }

    public CommandHistoryStorage getCommandHistoryStorage() {
        return myCommandHistoryStorage;
    }

    public CommandVariableStorage getCommandVariableStorage() {
        return myCommandVariableStorage;
    }

    public Notifications getNotifications() {
        return myNotifications;
    }

    public double getNumTurtles() {
        return myTurtleStorage.size();
    }
}
