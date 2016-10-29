package model.command.oneParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;


public class SetShape extends AbstractCommandOneParameterTurtle {

    public SetShape(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        double newShape = getParameters().get(PARAMETER_ONE);
        myTurtle.setShape(newShape);
        return newShape;
    }
}
