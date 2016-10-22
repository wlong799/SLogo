package model.command;

import model.ExpressionNode;
import java.util.List;


public class LessP extends AbstractCommandTwoParameterBoolean {

    public LessP(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        Operation less = (double numOne, double numTwo) -> {return numOne < numTwo;};
        return executionHelp(less);
    }
}
