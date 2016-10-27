package model.command.twoParameter.bool;


import java.util.List;
import model.command.AbstractCommand;


public class Equal extends AbstractCommandTwoParameterBoolean {

    public Equal(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation equal = (double numOne, double numTwo) -> {return numOne == numTwo;};
        return executionHelpBoolean(equal);
    }
}
