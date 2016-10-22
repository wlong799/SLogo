package model.command;

import model.ExpressionNode;
import java.util.List;


public class Sin extends AbstractCommandOneParameterMath {
    public Sin(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation sin = (double num) -> {return Math.sin(Math.toRadians(num));};
        return executionHelpMath(sin);
    }
}
