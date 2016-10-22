package model.command;

import model.ExpressionNode;
import java.util.List;


public class Equal extends AbstractCommandTwoParameterBoolean {

    public Equal(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation equal = (double numOne, double numTwo) -> {return numOne == numTwo;};
        return executionHelpBoolean(equal);
    }
}
