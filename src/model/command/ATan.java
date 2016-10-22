package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class ATan extends AbstractCommandOneParameterMath {
    public ATan(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation atan = (double num) -> {
            double result;
            try{
                result = Math.atan(Math.toRadians(num));
            }
            catch(Exception e){
                result = 0;
            }
            return result;
        };

        return executionHelpMath(atan);
    }
}
