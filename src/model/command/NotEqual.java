package model.command;


import java.util.List;


public class NotEqual extends AbstractCommandTwoParameterBoolean {

    public NotEqual(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation notEqual = (double numOne, double numTwo) -> {return numOne != numTwo;};
        return executionHelpBoolean(notEqual);
    }
}
