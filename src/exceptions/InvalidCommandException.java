package exceptions;

public class InvalidCommandException extends Exception {

    private final String myInvalidCommand;

    public InvalidCommandException (String command) {
        super();
        myInvalidCommand = command;
    }

    @Override
    public String getMessage () {
        return "The command " + myInvalidCommand + " is not valid";
    }
}
