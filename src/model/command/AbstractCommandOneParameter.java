package model.command;


import model.ExpressionNode;
import java.util.List;

abstract class AbstractCommandOneParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 1;
    static final int PARAMETER_ONE = 0;

    public AbstractCommandOneParameter(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
