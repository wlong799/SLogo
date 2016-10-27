package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractCommandOneParameterMath extends AbstractCommandOneParameter {
    public AbstractCommandOneParameterMath(List<AbstractCommand> parameters) {
        super(parameters);
    }

    interface MathOperation {
        double operate(double a);
    }

    protected double executionHelpMath(MathOperation o) {
        ArrayList<Double> operationParameters = getParameters();
        double numOne = operationParameters.get(PARAMETER_ONE);
        return o.operate(numOne);
    }
}
