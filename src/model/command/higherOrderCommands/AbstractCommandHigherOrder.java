package model.command.higherOrderCommands;

import java.util.List;
import dataStorage.*;
import model.command.AbstractCommand;


public abstract class AbstractCommandHigherOrder extends AbstractCommand {

    private DataStorageManager myData;

    public AbstractCommandHigherOrder (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public AbstractCommandHigherOrder () {
        super();
    }

    @Override
    public void addOtherParameters (DataStorageManager data, TurtleStorage turtles) {
        myData = data;
    }

    public abstract double execute ();
    
    protected DataStorageManager getData() {
        return myData;
    }
    
    @Override
    public int getNumParameters () {
        return 2;
    }

}
