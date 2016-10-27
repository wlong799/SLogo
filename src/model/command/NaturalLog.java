package model.command;


import java.util.ArrayList;
import java.util.List;


public class NaturalLog extends AbstractCommandOneParameterMath {
    public NaturalLog(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation log = (double num) -> {return Math.log(Math.toRadians(num));};
        return executionHelpMath(log);
    }
}
