package model.command;

import model.ExpressionNode;
import java.util.List;


public class Product extends AbstractCommandTwoParameterMath {
    public Product(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation quotient = (double numOne, double numTwo) -> {return numOne * numTwo;};
        return executionHelpMath(quotient);
    }
}