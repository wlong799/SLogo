package exceptions;

public class CustomCommandException extends Exception {

    private final String myCustomCommand;
    private final String myCustomCommandString;

    public CustomCommandException (String commandName, String commandString) {
        super();
        myCustomCommand = commandName;
        myCustomCommandString = commandString;
    }

    @Override
    public String getMessage () {
        return String.format(
                             "There was an error parsing the custom command %s. " +
                             "The command string %s is invalid.",
                             myCustomCommand, myCustomCommandString);
    }
}
