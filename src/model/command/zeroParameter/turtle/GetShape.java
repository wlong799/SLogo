package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import java.util.List;


public class GetShape extends AbstractCommandZeroParameterTurtle {
    public GetShape(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getShape();
    }
}
