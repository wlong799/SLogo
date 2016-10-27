package model.command;

import java.util.List;


public class PenUp extends AbstractCommandZeroParameterTurtle {

    private static final double PEN_UP_RETURN = 0;
    private static final boolean PEN_DOWN_STATUS = false;


    public PenUp(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        myTurtle.setPenDownStatus(PEN_DOWN_STATUS);
        return PEN_UP_RETURN;
    }
}
