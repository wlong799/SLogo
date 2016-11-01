package exceptions;

public class InvalidParenthesesException extends Exception {

    private final String invalidString;

    public InvalidParenthesesException (String message) {
        super();
        invalidString = message;
    }

    @Override
    public String getMessage () {
        return String.format("The command %s is missing a closing parenthesis", invalidString);
    }
}
