package model.command;


import model.ExpressionNode;
import java.util.List;

abstract class AbstractCommandTwoParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 2;
    static final int PARAMETER_ONE = 0;
    static final int PARAMETER_TWO = 1;

    AbstractCommandTwoParameter(List<ExpressionNode> parameters) {
        super(parameters);
    }

    int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
