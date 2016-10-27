package model.command;



import java.util.ArrayList;
import java.util.List;


public abstract class AbstractCommandTwoParameterBoolean extends AbstractCommandTwoParameter {

    protected static final double TRUE_RETURN = 1;
    protected static final double FALSE_RETURN = 0;

    public AbstractCommandTwoParameterBoolean(List<AbstractCommand> parameters) {
        super(parameters);
    }


    interface BooleanOperation {
        boolean operate(double a, double b);
    }

    protected double executionHelpBoolean(BooleanOperation o) {
        ArrayList<Double> operationParameters = getParameters();
        double numOne = operationParameters.get(PARAMETER_ONE);
        double numTwo = operationParameters.get(PARAMETER_TWO);
        return o.operate(numOne, numTwo) ? TRUE_RETURN : FALSE_RETURN;
    }

}
