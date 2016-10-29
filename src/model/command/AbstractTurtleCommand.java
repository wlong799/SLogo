package model.command;

import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;


public abstract class AbstractTurtleCommand extends AbstractCommand {

    protected Turtle myTurtle;
    private TurtleStorage myTurtles;

    public AbstractTurtleCommand (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public void addOtherParameters (DataStorageManager data, TurtleStorage turtles) {
        myTurtles = turtles;
    }
    
    protected TurtleStorage getTurtles () {
        return myTurtles;
    }
    protected abstract double turtleExecute ();
    
    @Override
    public double execute () {
        double output = 0.0;
        for (Turtle t : getTurtles().getActiveTurtles()) {
            myTurtle = t;
            System.out.println(t.getID());
            output = turtleExecute();
        }
        return output;
    }
}
