package model.command;


import java.util.List;


public class And extends AbstractCommandTwoParameterBoolean {

    public And(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation and = (double numOne, double numTwo) -> {return (numOne > 0) && (numTwo > 0);};
        return executionHelpBoolean(and);
    }
}
