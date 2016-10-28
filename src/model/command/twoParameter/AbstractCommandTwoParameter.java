package model.command.twoParameter;



import java.util.List;
import model.command.AbstractCommand;

public abstract class AbstractCommandTwoParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 2;
    protected static final int PARAMETER_ONE = 0;
    protected static final int PARAMETER_TWO = 1;

    public AbstractCommandTwoParameter(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
