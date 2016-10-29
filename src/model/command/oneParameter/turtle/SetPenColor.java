package model.command.oneParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class SetPenColor extends AbstractCommandOneParameterTurtle {

    public SetPenColor(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        double newPenColor = getParameters().get(PARAMETER_ONE);
        myTurtle.setPenColor(newPenColor);
        return newPenColor;
    }
}
