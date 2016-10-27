package model.command;


import java.util.List;


public class GreaterThan extends AbstractCommandTwoParameterBoolean {

    public GreaterThan(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation greater = (double numOne, double numTwo) -> {return numOne > numTwo;};
        return executionHelpBoolean(greater);
    }
}
