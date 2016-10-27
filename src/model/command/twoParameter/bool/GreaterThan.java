package model.command.twoParameter.bool;


import java.util.List;
import model.command.AbstractCommand;


public class GreaterThan extends AbstractCommandTwoParameterBoolean {

    public GreaterThan(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation greater = (double numOne, double numTwo) -> {return numOne > numTwo;};
        return executionHelpBoolean(greater);
    }
}
