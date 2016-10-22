package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Cos extends AbstractCommandOneParameterMath {
    public Cos(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation cos = (double num) -> {return Math.cos(Math.toRadians(num));};
        return executionHelpMath(cos);
    }
}
