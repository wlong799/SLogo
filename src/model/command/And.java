package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class And extends AbstractCommandTwoParameter {
    private static final double TRUE_RETURN = 1;
    private static final double FALSE_RETURN = 0;

    public And(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        ArrayList<Double> operationParameters = getParameters();
        double numOne = operationParameters.get(PARAMETER_ONE);
        double numTwo = operationParameters.get(PARAMETER_TWO);

        return (numOne > 0) && (numTwo > 0) ? TRUE_RETURN : FALSE_RETURN;
    }
}
