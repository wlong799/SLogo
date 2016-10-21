package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class ATan extends AbstractCommandOneParameter {
    public ATan(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        ArrayList<Double> operationParameters = getParameters();
        double num = operationParameters.get(PARAMETER_ONE);
        double result;
        try{
            result = Math.atan(Math.toRadians(num));
        }
        catch(Exception e){
            result = 0;
        }

        return result;
    }
}
