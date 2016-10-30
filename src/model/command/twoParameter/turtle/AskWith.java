package model.command.twoParameter.turtle;

import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;


public class AskWith extends AbstractCommandTwoParameterTurtle {

    public AskWith (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return turtleExecute();
    }

    @Override
    protected double turtleExecute () {
        List<Integer> activeTurtles = new ArrayList<Integer>(getTurtles().getActiveTurtleIDs());
        List<Integer> activeSingleTurtle = new ArrayList<Integer>();
        double output = 0;
        for (int i : activeTurtles) {
            activeSingleTurtle.clear();
            activeSingleTurtle.add(i);
            getTurtles().setActiveTurtles(activeSingleTurtle);
            if (getRawParameters().get(PARAMETER_ONE).execute() == 1.0) {
                output = getRawParameters().get(PARAMETER_TWO).execute();
            }

        }
        getTurtles().setActiveTurtles(activeTurtles);
        return output;
    }

}
