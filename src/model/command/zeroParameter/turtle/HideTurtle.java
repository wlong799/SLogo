package model.command.zeroParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class HideTurtle extends AbstractCommandZeroParameterTurtle {
    private static final double VISIBILITY_RETURN = 0;
    private static final boolean VISIBILITY_STATUS = false;

    public HideTurtle (List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double turtleExecute () {
        myTurtle.setVisibility(VISIBILITY_STATUS);
        return VISIBILITY_RETURN;
    }
}
