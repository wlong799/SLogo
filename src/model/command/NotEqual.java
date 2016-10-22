package model.command;

import model.ExpressionNode;
import java.util.List;


public class NotEqual extends AbstractCommandTwoParameterBoolean {

    public NotEqual(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation notEqual = (double numOne, double numTwo) -> {return numOne != numTwo;};
        return executionHelpBoolean(notEqual);
    }
}
