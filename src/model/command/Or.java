package model.command;

import model.ExpressionNode;
import java.util.List;


public class Or extends AbstractCommandTwoParameterBoolean {

    public Or(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        Operation and = (double numOne, double numTwo) -> {return (numOne > 0) || (numTwo > 0);};
        return executionHelp(and);
    }
}
