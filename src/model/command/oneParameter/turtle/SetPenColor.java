package model.command.oneParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class SetPenColor extends AbstractCommandOneParameterTurtle {

    public SetPenColor(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double turtleExecute() {
        double newPenColor = getParameters().get(PARAMETER_ONE);
        myTurtle.setPenColor(newPenColor);
        return newPenColor;
    }
}
