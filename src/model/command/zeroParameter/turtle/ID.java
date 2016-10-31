package model.command.zeroParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;



/**
 * 
 * @author Michael Schroeder
 *
 */

public class ID extends AbstractCommandZeroParameterTurtle {

    public ID (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    protected double turtleExecute () {
        System.out.println(myTurtle.getID() +" ID");
        return (double)myTurtle.getID();
    }

}