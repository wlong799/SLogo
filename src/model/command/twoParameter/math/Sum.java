package model.command.twoParameter.math;


import java.util.List;
import model.command.AbstractCommand;


public class Sum extends AbstractCommandTwoParameterMath {
    public Sum(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation sum = (double numOne, double numTwo) -> {return numOne + numTwo;};
        return executionHelpMath(sum);
    }
}
