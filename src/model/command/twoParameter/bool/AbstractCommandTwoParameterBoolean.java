package model.command.twoParameter.bool;

import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;
import model.command.twoParameter.AbstractCommandTwoParameter;


public abstract class AbstractCommandTwoParameterBoolean extends AbstractCommandTwoParameter {

    protected static final double TRUE_RETURN = 1;
    protected static final double FALSE_RETURN = 0;

    public AbstractCommandTwoParameterBoolean (List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double executionHelpBoolean (BooleanOperation o) {
        ArrayList<Double> operationParameters = getParameters();
        double numOne = operationParameters.get(PARAMETER_ONE);
        double numTwo = operationParameters.get(PARAMETER_TWO);
        return o.operate(numOne, numTwo) ? TRUE_RETURN : FALSE_RETURN;
    }

    interface BooleanOperation {
        boolean operate (double a, double b);
    }

}
