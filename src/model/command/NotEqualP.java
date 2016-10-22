package model.command;

import model.ExpressionNode;
import java.util.List;


public class NotEqualP extends AbstractCommandTwoParameterBoolean {

    public NotEqualP(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        Operation notEqual = (double numOne, double numTwo) -> {return numOne != numTwo;};
        return executionHelp(notEqual);
    }
}
