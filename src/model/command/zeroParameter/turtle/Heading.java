package model.command.zeroParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class Heading extends AbstractCommandZeroParameterTurtle {
    public Heading (List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double turtleExecute () {
        return myTurtle.getHeading();
    }
}
