package dataStorage;

class SubDataStorageManager {
    private Turtle myTurtle;
    private ValueVariableStorage myValueVariableStorage;
    private CommandHistoryStorage myCommandHistoryStorage;
    private CommandVariableStorage myCommandVariableStorage;
    private Notifications myNotifications;

    SubDataStorageManager() {
        myTurtle = new Turtle();
        myValueVariableStorage = new ValueVariableStorage();
        myCommandVariableStorage = new CommandVariableStorage();
        myCommandHistoryStorage = new CommandHistoryStorage();
        myNotifications = new Notifications();
    }

    public Turtle getTurtle() {
        return myTurtle;
    }

    ValueVariableStorage getValueVariableStorage() {
        return myValueVariableStorage;
    }

    CommandHistoryStorage getCommandHistoryStorage() {
        return myCommandHistoryStorage;
    }

    CommandVariableStorage getCommandVariableStorage() {
        return myCommandVariableStorage;
    }

    Notifications getNotifications() {
        return myNotifications;
    }
}
