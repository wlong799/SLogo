package model.command.higherOrderCommands;

import java.util.List;
import model.command.AbstractCommand;

/**
 * 
 * @author Michael Schroeder
 *
 */
public class Variable extends AbstractCommandHigherOrder {

    private String myVariableName;

    public Variable (String name) {
        super();
        myVariableName = name;
    }

    public Variable (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public String toString () {
        return myVariableName;
    }

    @Override
    public double execute () {
        return getData().getVariable(myVariableName);
    }

    @Override
    public int getNumParameters () {
        return 0;
    }


}
