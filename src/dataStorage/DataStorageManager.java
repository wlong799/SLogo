package dataStorage;


public class DataStorageManager {
    private Turtle myTurtle;
    private VariableStorage myVariableStorage;

    private static DataStorageManager instance = new DataStorageManager();

    private DataStorageManager() {
        myTurtle = new Turtle();
        myVariableStorage = new VariableStorage();
    }

    public static DataStorageManager get() {
        return instance;
    }

    public Turtle getTurtle() {
        return myTurtle;
    }

    public VariableStorage getVariableStorage() {
        return myVariableStorage;
    }
}
