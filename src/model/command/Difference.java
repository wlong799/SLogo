package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Difference extends AbstractCommandTwoParameter {
    public Difference(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        ArrayList<Double> operationParameters = getParameters();
        double numOne = operationParameters.get(PARAMETER_ONE);
        double numTwo = operationParameters.get(PARAMETER_TWO);

        return numOne - numTwo;
    }
}
