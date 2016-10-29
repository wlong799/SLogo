package model.command.oneParameter;

import java.util.List;
import model.command.AbstractCommand;


public abstract class AbstractCommandOneParameter extends AbstractCommand
        implements IOneParameterCommand {

    public AbstractCommandOneParameter (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public int getNumParameters () {
        return NUM_PARAMETERS;
    }
}
