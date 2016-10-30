package model.command.zeroParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;

public class ID extends AbstractCommandZeroParameterTurtle {

    public ID (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    protected double turtleExecute () {
        return myTurtle.getID();
    }

}