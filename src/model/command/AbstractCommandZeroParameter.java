package model.command;


import model.ExpressionNode;
import java.util.List;

public abstract class AbstractCommandZeroParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 0;

    public AbstractCommandZeroParameter(List<AbstractCommand> parameters) {
        super(parameters);
    }
    public AbstractCommandZeroParameter() {
        super();
    }

    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
