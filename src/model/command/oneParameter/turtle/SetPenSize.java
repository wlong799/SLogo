package model.command.oneParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class SetPenSize extends AbstractCommandOneParameterTurtle {

    public SetPenSize(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        double newPenSize = getParameters().get(PARAMETER_ONE);
        myTurtle.setPenSize(newPenSize);
        return newPenSize;
    }
}
