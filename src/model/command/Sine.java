package model.command;

import model.ExpressionNode;
import java.util.List;


public class Sine extends AbstractCommandOneParameterMath {
    public Sine(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation sin = (double num) -> {return Math.sin(Math.toRadians(num));};
        return executionHelpMath(sin);
    }
}
