package model.command;

import java.util.ArrayList;
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
        List<Turtle> activeTurtles = new ArrayList<Turtle>(getTurtles().getActiveTurtles());
        List<Integer> activeSingleTurtles = new ArrayList<Integer>();
        for (Turtle t : activeTurtles) {
            activeSingleTurtles.clear();
            activeSingleTurtles.add(t.getID());
            getTurtles().setActiveTurtles(activeSingleTurtles);
            myTurtle = t;
            System.out.println(t.getID());
            output = turtleExecute();
        }
        activeSingleTurtles.clear();
        activeTurtles.stream().forEach(t -> activeSingleTurtles.add(t.getID()));
        getTurtles().setActiveTurtles(activeSingleTurtles);
        return output;
    }
}
