package model.command;


import java.util.List;


public class YCoordinate extends AbstractCommandZeroParameterTurtle {
    public YCoordinate(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPosition().getY();
    }
}
