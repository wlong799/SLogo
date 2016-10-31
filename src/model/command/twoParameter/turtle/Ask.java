package model.command.twoParameter.turtle;

import java.util.ArrayList;
import java.util.List;
import dataStorage.TurtleStorage;
import model.command.AbstractCommand;
import model.command.ListCommand; 

/**
 * 
 * @author Michael Schroeder
 *
 */

public class Ask extends AbstractCommandTwoParameterTurtle {

    public Ask (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return turtleExecute();
    }

    @Override
    protected double turtleExecute () {
        TurtleStorage turtles = getTurtles();
        List<Integer> oldTurtles = new ArrayList<Integer>(turtles.getActiveTurtleIDs());
        ListCommand idCommand = (ListCommand)getRawParameters().get(PARAMETER_ONE);
        List<Double> newTurtles = idCommand.getParameters();
        List<Integer> newTurtleIDs = new ArrayList<Integer>();
        newTurtles.stream().forEach(d -> newTurtleIDs.add(d.intValue()));
        turtles.setActiveTurtles(newTurtleIDs);
        double output = getRawParameters().get(PARAMETER_TWO).execute();
        turtles.setActiveTurtles(oldTurtles);
        return output;
    }

}
