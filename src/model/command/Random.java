package model.command;

import model.ExpressionNode;
import java.util.List;


public class Random extends AbstractCommandOneParameterMath {
    public Random(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation minus = (double num) -> {return Math.random() * num;};
        return executionHelpMath(minus);
    }
}
