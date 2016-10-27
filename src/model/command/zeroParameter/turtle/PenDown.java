package model.command.zeroParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;



public class PenDown extends AbstractCommandZeroParameterTurtle {

    private static final double PEN_DOWN_RETURN = 1;
    private static final boolean PEN_DOWN_STATUS = true;

    public PenDown(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        myTurtle.setPenDownStatus(PEN_DOWN_STATUS);

        return PEN_DOWN_RETURN;
    }
}
