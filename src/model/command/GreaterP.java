package model.command;

import model.ExpressionNode;
import java.util.List;


public class GreaterP extends AbstractCommandTwoParameterBoolean {

    public GreaterP(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation greater = (double numOne, double numTwo) -> {return numOne > numTwo;};
        return executionHelpBoolean(greater);
    }
}
