package model.command.oneParameter.math;


import java.util.List;
import model.command.AbstractCommand;


public class Random extends AbstractCommandOneParameterMath {
    public Random(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation minus = (double num) -> {return Math.random() * num;};
        return executionHelpMath(minus);
    }
}
