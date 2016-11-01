package model.command.zeroParameter.turtle;

import java.util.List;
import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.AbstractTurtleCommand;


public abstract class AbstractCommandZeroParameterTurtle extends AbstractTurtleCommand
        implements IZeroParameterCommand {

    AbstractCommandZeroParameterTurtle (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public void setTurtle (Turtle turtle) {
        myTurtle = turtle;
    }

    @Override
    public int getNumParameters () {
        return NUM_PARAMETERS;
    }
}
