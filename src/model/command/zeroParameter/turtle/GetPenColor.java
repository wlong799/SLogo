package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import java.util.List;


public class GetPenColor extends AbstractCommandZeroParameterTurtle {
    public GetPenColor(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPenColor();
    }
}
