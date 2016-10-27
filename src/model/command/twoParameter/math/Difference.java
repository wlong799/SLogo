package model.command.twoParameter.math;


import java.util.List;
import model.command.AbstractCommand;


public class Difference extends AbstractCommandTwoParameterMath {
    public Difference(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation sum = (double numOne, double numTwo) -> {return numOne - numTwo;};
        return executionHelpMath(sum);
    }
}
