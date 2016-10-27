package model.command;

import model.ExpressionNode;
import java.util.List;


public class Difference extends AbstractCommandTwoParameterMath {
    public Difference(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation sum = (double numOne, double numTwo) -> {return numOne - numTwo;};
        return executionHelpMath(sum);
    }
}
