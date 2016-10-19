package model.command;


import model.ExpressionNode;
import java.util.List;

abstract class AbstractCommandOneParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 1;
    static final int PARAMETER_ONE = 0;

    AbstractCommandOneParameter(List<ExpressionNode> parameters) {
        super(parameters);
    }

    int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
