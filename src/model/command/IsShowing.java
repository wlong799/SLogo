package model.command;

import model.ExpressionNode;
import java.util.List;


public class IsShowing extends AbstractCommandZeroParameterTurtle {
    private static final double RETURN_SHOWING = 1;
    private static final double RETURN_NOT_SHOWING = 0;

    public IsShowing(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getVisibility() ? RETURN_SHOWING : RETURN_NOT_SHOWING;
    }
}
