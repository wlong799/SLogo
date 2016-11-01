package model.command.higherOrderCommands;

import java.util.List;
import dataStorage.*;
import model.command.AbstractCommand;


public abstract class AbstractCommandHigherOrder extends AbstractCommand {

    private DataStorageManager myData;
    private TurtleStorage myTurtles;

    public AbstractCommandHigherOrder (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public AbstractCommandHigherOrder () {
        super();
    }


    @Override
    public void addOtherParameters (DataStorageManager data, TurtleStorage turtles) {
        myData = data;
        myTurtles = turtles;
    }

    public abstract double execute ();
    
    protected DataStorageManager getData() {
        return myData;
    }

    protected TurtleStorage getTurtles() {
        return myTurtles;
    }
    
    @Override
    public int getNumParameters () {
        return 2;
    }

//    protected ColorStorage getColors() {
//        return myColors;
//    }
}
