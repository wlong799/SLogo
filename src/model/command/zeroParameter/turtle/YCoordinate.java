package model.command.zeroParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class YCoordinate extends AbstractCommandZeroParameterTurtle {
    public YCoordinate (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    protected double turtleExecute () {
        return myTurtle.getPosition().getY();
    }
}
