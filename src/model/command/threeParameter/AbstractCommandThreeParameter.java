package model.command.threeParameter;

import java.util.List;
import model.command.AbstractCommand;


abstract class AbstractCommandThreeParameter extends AbstractCommand {
    protected static final int PARAMETER_ONE = 0;
    protected static final int PARAMETER_TWO = 1;
    protected static final int PARAMETER_THREE = 2;
    private static final int NUM_PARAMETERS = 3;

    AbstractCommandThreeParameter (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public int getNumParameters () {
        return NUM_PARAMETERS;
    }
}
