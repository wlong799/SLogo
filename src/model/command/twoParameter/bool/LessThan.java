package model.command.twoParameter.bool;


import java.util.List;
import model.command.AbstractCommand;


public class LessThan extends AbstractCommandTwoParameterBoolean {

    public LessThan(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation less = (double numOne, double numTwo) -> {return numOne < numTwo;};
        return executionHelpBoolean(less);
    }
}
