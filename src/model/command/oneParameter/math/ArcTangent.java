package model.command.oneParameter.math;


import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;


public class ArcTangent extends AbstractCommandOneParameterMath {
    public ArcTangent(List<AbstractCommand> parameters) {
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
