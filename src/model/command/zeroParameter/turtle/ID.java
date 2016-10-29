package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import java.util.List;


public class ID extends AbstractCommandZeroParameterTurtle {
    public ID(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double turtleExecute() {
        return myTurtle.getID();
    }
}
