package model.command.zeroParameter.turtle;


import java.util.List;
import model.command.AbstractCommand;


public class YCoordinate extends AbstractCommandZeroParameterTurtle {
    public YCoordinate(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPosition().getY();
    }
}
