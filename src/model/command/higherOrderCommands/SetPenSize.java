package model.command.higherOrderCommands;

import java.util.List;
import model.command.AbstractCommand;
import model.command.oneParameter.turtle.AbstractCommandOneParameterTurtle;


public class SetPenSize extends AbstractCommandHigherOrder {

    public SetPenSize (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute () {
        double newPenSize = getParameters().get(0);
        getData().getColors().setPenSize(newPenSize);
        return newPenSize;
    }
}
