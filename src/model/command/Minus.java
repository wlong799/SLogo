package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Minus extends AbstractCommandOneParameterMath {
    public Minus(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation minus = (double num) -> {return -num;};
        return executionHelpMath(minus);
    }
}
