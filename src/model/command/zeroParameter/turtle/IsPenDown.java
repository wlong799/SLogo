package model.command.zeroParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class IsPenDown extends AbstractCommandZeroParameterTurtle {
    private static final double RETURN_PENDOWN = 1;
    private static final double RETURN_PENUP = 0;

    public IsPenDown (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    protected double turtleExecute () {
        return myTurtle.getPenDownStatus() ? RETURN_PENDOWN : RETURN_PENUP;
    }
}
