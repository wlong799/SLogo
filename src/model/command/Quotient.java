package model.command;


import java.util.List;


public class Quotient extends AbstractCommandTwoParameterMath {
    public Quotient(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        MathOperation quotient = (double numOne, double numTwo) -> {return numOne / numTwo;};
        return executionHelpMath(quotient);
    }
}
