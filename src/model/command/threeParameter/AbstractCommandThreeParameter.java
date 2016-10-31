package model.command.threeParameter;

import java.util.List;
import model.command.AbstractCommand;

abstract class AbstractCommandThreeParameter extends AbstractCommand implements IThreeParameterCommand{


    AbstractCommandThreeParameter (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public int getNumParameters () {
        return NUM_PARAMETERS;
    }
}
