package model.command;

import model.ExpressionNode;
import java.util.List;


public class Pow extends AbstractCommandTwoParameterMath {
    public Pow(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation pow = (double numOne, double numTwo) -> {return Math.pow(numOne, numTwo);};
        return executionHelpMath(pow);
    }
}
