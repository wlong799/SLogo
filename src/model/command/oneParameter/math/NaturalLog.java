package model.command.oneParameter.math;


import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;


public class NaturalLog extends AbstractCommandOneParameterMath {
    public NaturalLog(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation log = (double num) -> {return Math.log(Math.toRadians(num));};
        return executionHelpMath(log);
    }
}
