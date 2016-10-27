package model.command;

import model.ExpressionNode;
import java.util.List;


public class Or extends AbstractCommandTwoParameterBoolean {

    public Or(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation and = (double numOne, double numTwo) -> {return (numOne > 0) || (numTwo > 0);};
        return executionHelpBoolean(and);
    }
}
