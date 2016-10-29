package model.command.oneParameter.turtle;

import java.util.List;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;
import model.command.AbstractCommand;
import model.command.AbstractTurtleCommand;
import model.command.oneParameter.AbstractCommandOneParameter;
import model.command.oneParameter.IOneParameterCommand;
import dataStorage.DataStorageManager;


public abstract class AbstractCommandOneParameterTurtle extends AbstractTurtleCommand
        implements IOneParameterCommand {
    

    public AbstractCommandOneParameterTurtle (List<AbstractCommand> parameters) {
        super(parameters);
        // myTurtle = DataStorageManager.get().getTurtle();
    }

    

    

    public int getNumParameters () {
        return NUM_PARAMETERS;
    }

}
