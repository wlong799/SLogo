package model.command;

import model.ExpressionNode;
import java.util.List;


public class Quotient extends AbstractCommandTwoParameterMath {
    public Quotient(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation quotient = (double numOne, double numTwo) -> {return numOne / numTwo;};
        return executionHelpMath(quotient);
    }
}
