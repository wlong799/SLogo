package model.command;


import model.ExpressionNode;
import java.util.List;

public abstract class AbstractCommandTwoParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 2;
    static final int PARAMETER_ONE = 0;
    static final int PARAMETER_TWO = 1;

    public AbstractCommandTwoParameter(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
