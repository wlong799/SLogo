package model.command.oneParameter;

import java.util.List;
import model.command.AbstractCommand;


public abstract class AbstractCommandOneParameter extends AbstractCommand {
    
    protected static final int PARAMETER_ONE = 0;
    private static final int NUM_PARAMETERS = 1;
    

    public AbstractCommandOneParameter (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public int getNumParameters () {
        return NUM_PARAMETERS;
    }
}
