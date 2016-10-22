package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Tan extends AbstractCommandOneParameterMath {
    public Tan(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation tan = (double num) -> {
            double result;
            try{
                result = Math.tan(Math.toRadians(num));
            }
            catch(Exception e){
                result = 0;
            }
            return result;
        };

        return executionHelpMath(tan);
    }
}
