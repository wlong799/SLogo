package dataStorage;

public class SubDataStorageManager {
    private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandVariableStorage myCommandVariableStorage;
    private Notifications myNotifications;

    public SubDataStorageManager() {
        myTurtle = new Turtle();
        myValueVariableStorage = new ValueVariableStorage();
        myCommandVariableStorage = new CommandVariableStorage();
        myCommandHistoryStorage = new CommandHistoryStorage();
        myNotifications = new Notifications();
    }

    public Turtle getTurtle() {
        return myTurtle;
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
}
