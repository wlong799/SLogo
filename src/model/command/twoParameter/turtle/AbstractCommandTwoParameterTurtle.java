package model.command.twoParameter.turtle;

import java.util.List;
import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.AbstractTurtleCommand;
import model.command.twoParameter.ITwoParameterCommand;


public abstract class AbstractCommandTwoParameterTurtle extends AbstractTurtleCommand
        implements ITwoParameterCommand {

    AbstractCommandTwoParameterTurtle (List<AbstractCommand> parameters) {
        super(parameters);
        // myTurtle = DataStorageManager.get().getTurtle();
    }

    public void setTurtle (Turtle turtle) {
        myTurtle = turtle;
    }


    public int getNumParameters () {
        return NUM_PARAMETERS;
    }
}
