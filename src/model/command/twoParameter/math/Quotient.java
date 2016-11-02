package model.command.twoParameter.math;


import java.util.List;
import model.command.AbstractCommand;


public class Quotient extends AbstractCommandTwoParameterMath{

    public Quotient(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation quotient = (double numOne, double numTwo) -> {return numOne / numTwo;};
        try {
            return executionHelpMath(quotient);
        }
        catch (ArithmeticException e) {
            throw new ArithmeticException("Division by zero error");
        }
    }
}
