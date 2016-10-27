package model.command;

import model.ExpressionNode;
import java.util.List;


public class LessThan extends AbstractCommandTwoParameterBoolean {

    public LessThan(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation less = (double numOne, double numTwo) -> {return numOne < numTwo;};
        return executionHelpBoolean(less);
    }
}
