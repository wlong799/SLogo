package dataStorage;

import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;


/**
 * @author Filip Mazurek
 * @author Michael Schroeder
 */

public class DataStorageManager {

    private VariableStorage myVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandStorage myCommandStorage;
    private Notifications myNotifications;
    private ColorStorage myColorStorage;

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

    public Notifications getNotifications () {
        return myNotifications;
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

    // public ObservableList<Integer> getBackgroundColor () {
    // return myColorStorage.getColor();
    // }

    // public int addColor (int index) {
    // myColorStorage.addColor(index);
    // return index;
    // }

    public void addHistory (String command) {
        myCommandHistoryStorage.addCommand(command);
    }

    public ObservableList<String> getColorList () {
        return myColorStorage.getColorList();
    }

    public Map<String, Double> getValueVariableMap () {
        return myVariableStorage.getVariableMap();
    }

    public CommandStorage getCommandStorage () {
        return myCommandStorage;
    }

    /* functions for setting information using the XML content setter */

    public void setVariableStorage (VariableStorage variableStorage) {
        myVariableStorage = variableStorage;
    }

    public void setCommandStorage (CommandStorage commandStorage) {
        myCommandStorage = commandStorage;
    }

    public ColorStorage getColors () {
        return myColorStorage;
    }

    public void setColorStorage (ColorStorage colorStorage) {
        myColorStorage = colorStorage;
    }

    public void setColor (int index) {
        myColorStorage.setPenColor(index);
    }
    
    public void setBackgroundColor(int index){
        myColorStorage.setBackgroundColor(index);
    }

    public void addColor (int index, int red, int green, int blue) {
        myColorStorage.addColor(index, red, green, blue);
    }
}
