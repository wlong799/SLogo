package model.command.oneParameter.math;


import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;


public class Minus extends AbstractCommandOneParameterMath {
    public Minus(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation minus = (double num) -> {return -num;};
        return executionHelpMath(minus);
    }
}
