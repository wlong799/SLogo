package model.command;

import java.util.ArrayList;
import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;


/**
 * 
 * @author Michael Schroeder
 *
 */
public abstract class AbstractTurtleCommand extends AbstractCommand {
    private static final double CIRCLE_DEGREES = 360;

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

    protected void setTurtleStorage (TurtleStorage turtles) {
        myTurtles = turtles;
    }
    protected abstract double turtleExecute ();

    @Override
    public double execute () {
        ////System.out.println(this.getClass());
        //////System.out.println(myTurtles.getClass());
        ////System.out.println("BLAH");
        double output = 0.0;
        List<Turtle> activeTurtles = new ArrayList<Turtle>(myTurtles.getActiveTurtles());
        ////System.out.println(activeTurtles.size());
        List<Integer> activeSingleTurtles = new ArrayList<Integer>();
        for (Turtle t : activeTurtles) {
            ////System.out.println(this.getClass() + " turtle command");
            activeSingleTurtles.clear();
            activeSingleTurtles.add(t.getID());
            getTurtles().setActiveTurtles(activeSingleTurtles);
            myTurtle = t;
            ////System.out.println(t.getID());
            output = turtleExecute();
        }
        activeSingleTurtles.clear();
        activeTurtles.stream().forEach(t -> activeSingleTurtles.add(t.getID()));
        getTurtles().setActiveTurtles(activeSingleTurtles);
        getTurtles().updateTurtles();
        return output;
    }

    protected double correctOverTurns (double degrees) {
        int overByNumTurns = 0;
        if (Math.abs(degrees) >= CIRCLE_DEGREES) {
            overByNumTurns = (int) (degrees / CIRCLE_DEGREES);
        }
        double newDegrees = degrees - overByNumTurns * CIRCLE_DEGREES;

        if (newDegrees < 0) {
            newDegrees += CIRCLE_DEGREES;
        }
        return newDegrees;
    }

    protected double distanceFormula (double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
