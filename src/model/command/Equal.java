package model.command;


import java.util.List;


public class Equal extends AbstractCommandTwoParameterBoolean {

    public Equal(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        BooleanOperation equal = (double numOne, double numTwo) -> {return numOne == numTwo;};
        return executionHelpBoolean(equal);
    }
}
