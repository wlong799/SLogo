package model.command.zeroParameter.turtle;


<<<<<<< HEAD:src/model/command/XCoordinate.java
import model.ExpressionNode;
=======


>>>>>>> master:src/model/command/zeroParameter/turtle/XCoordinate.java
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
