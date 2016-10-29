package model.command.twoParameter;

import java.util.List;
import model.command.AbstractCommand;


public abstract class AbstractCommandTwoParameter extends AbstractCommand
        implements ITwoParameterCommand {

    public AbstractCommandTwoParameter (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public int getNumParameters () {
        return NUM_PARAMETERS;
    }
}
