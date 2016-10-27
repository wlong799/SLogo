package model.command;




import java.util.List;

public class XCoordinate extends AbstractCommandZeroParameterTurtle {
    public XCoordinate(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPosition().getX();
    }
}
