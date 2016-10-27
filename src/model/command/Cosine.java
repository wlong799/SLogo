package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Cosine extends AbstractCommandOneParameterMath {
    public Cosine(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation cos = (double num) -> {return Math.cos(Math.toRadians(num));};
        return executionHelpMath(cos);
    }
}
