package dataStorage;

import java.util.List;
import javafx.collections.ObservableList;


/**
 * @author Filip Mazurek
 * @author Michael Schroeder
 */
public class DataStorageManager {

    private VariableStorage myVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandStorage myCommandStorage;
    private ColorStorage myColorStorage;
    private Notifications myNotifications;

    public DataStorageManager () {
        myVariableStorage = new VariableStorage();
        myCommandStorage = new CommandStorage();
        myCommandHistoryStorage = new CommandHistoryStorage();
        myNotifications = new Notifications();
        myColorStorage = new ColorStorage();
    }

    public Double getVariable (String varName) {
        return myVariableStorage.getVariable(varName);
    }

    public void setVariable (String varName, double value) {
        myVariableStorage.setVariable(varName, value);
    }

    public void setCommand (String commandName, List<String> parameterNames, String commandString) {
        myCommandStorage.setCommand(commandName, parameterNames, commandString);
    }

    public ObservableList<String> getVariableList () {
        return myVariableStorage.getVariableList();
    }

    public boolean hasCommand (String command) {
        return myCommandStorage.hasCommand(command);
    }

    public String getCommand (String command) {
        return myCommandStorage.getCommand(command);
    }

    public List<String> getCommandParams (String command) {
        return myCommandStorage.getCommandParams(command);
    }

    public ObservableList<String> getCommandList () {
        return myCommandStorage.getCommandVariableList();
    }

    public ObservableList<String> getHistoryList () {
        return myCommandHistoryStorage.getCommandHistoryList();
    }

    public ObservableList<Integer> getBackgroundColor () {
        return myColorStorage.getColor();
    }

    public int setColor (int index) {
        myColorStorage.setColor(index);
        return index;
    }

    public void addHistory (String command) {
        myCommandHistoryStorage.addCommand(command);
    }
}
