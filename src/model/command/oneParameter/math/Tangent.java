package model.command.oneParameter.math;


import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;


public class Tangent extends AbstractCommandOneParameterMath {
    public Tangent(List<AbstractCommand> parameters) {
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
