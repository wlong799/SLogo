package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Cos extends AbstractCommandOneParameter {
    public Cos(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        ArrayList<Double> operationParameters = getParameters();
        double num = operationParameters.get(PARAMETER_ONE);

        return Math.cos(Math.toRadians(num));
    }
}
