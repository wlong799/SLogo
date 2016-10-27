package model.command.twoParameter.bool;


import java.util.List;
import model.command.AbstractCommand;


public class NotEqual extends AbstractCommandTwoParameterBoolean {

    public NotEqual(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation notEqual = (double numOne, double numTwo) -> {return numOne != numTwo;};
        return executionHelpBoolean(notEqual);
    }
}
