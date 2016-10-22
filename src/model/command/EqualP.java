package model.command;

import model.ExpressionNode;
import java.util.List;


public class EqualP extends AbstractCommandTwoParameterBoolean {

    public EqualP(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation equal = (double numOne, double numTwo) -> {return numOne == numTwo;};
        return executionHelpBoolean(equal);
    }
}
