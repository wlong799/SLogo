package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractCommandTwoParameterMath extends AbstractCommandTwoParameter {
    public AbstractCommandTwoParameterMath(List<AbstractCommand> parameters) {
        super(parameters);
    }

    interface MathOperation {
        double operate(double a, double b);
    }

    protected double executionHelpMath(MathOperation o) {
        ArrayList<Double> operationParameters = getParameters();
        double numOne = operationParameters.get(PARAMETER_ONE);
        double numTwo = operationParameters.get(PARAMETER_TWO);
        return o.operate(numOne, numTwo);
    }
}
