package model.command.oneParameter.turtle;

import java.util.ArrayList;
import java.util.List;
import dataStorage.TurtleStorage;
import model.command.AbstractCommand;
import model.command.ListCommand;
import dataStorage.Turtle;

/**
 * 
 * @author Michael Schroeder
 *
 */

public class Tell extends AbstractCommandOneParameterTurtle {

    public Tell (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return turtleExecute();
    }

    @Override
    protected double turtleExecute () {
        ListCommand idCommand = (ListCommand)getRawParameters().get(PARAMETER_ONE);
        List<Double> newTurtleIDs = idCommand.getParameters();
        
        double output = 0;
        if (newTurtleIDs.size() > 0) {
            output = newTurtleIDs.get(newTurtleIDs.size() - 1);
        }
        List<Integer> turtleIDInts = new ArrayList<Integer>();
        newTurtleIDs.stream().forEach(d -> turtleIDInts.add(d.intValue()));
        getTurtles().setActiveTurtles(turtleIDInts);
        return output;
    }

}
