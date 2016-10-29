package model.command.zeroParameter.turtle;




import java.util.List;
import model.command.AbstractCommand;

public class XCoordinate extends AbstractCommandZeroParameterTurtle {
    public XCoordinate(List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double turtleExecute() {
        return myTurtle.getPosition().getX();
    }
}
