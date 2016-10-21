package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Tan extends AbstractCommandOneParameter {
    public Tan(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        ArrayList<Double> operationParameters = getParameters();
        double num = operationParameters.get(PARAMETER_ONE);
        double result;
        try{
            result = Math.tan(Math.toRadians(num));
        }
        catch(Exception e){
            result = 0;
        }

        return result;
    }
}
