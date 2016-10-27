package model.command.twoParameter.math;


import java.util.List;
import model.command.AbstractCommand;


public class Power extends AbstractCommandTwoParameterMath {
    public Power(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation pow = (double numOne, double numTwo) -> {return Math.pow(numOne, numTwo);};
        return executionHelpMath(pow);
    }
}
