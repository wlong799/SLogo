package model.command.oneParameter.math;


import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;
import model.command.oneParameter.AbstractCommandOneParameter;


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
