package dataStorage;


public class DataStorageManager {
    private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;

    private static DataStorageManager instance = new DataStorageManager();

    private DataStorageManager() {
        myTurtle = new Turtle();
        myValueVariableStorage = new ValueVariableStorage();
    }

    public static DataStorageManager get() {
        return instance;
    }

    public Turtle getTurtle() {
        return myTurtle;
    }

    public ValueVariableStorage getValueVariableStorage() {
        return myValueVariableStorage;
    }
}
