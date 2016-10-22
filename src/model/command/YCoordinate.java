package model.command;

import model.ExpressionNode;
import java.util.List;


public class YCoordinate extends AbstractCommandZeroParameterTurtle {
    public YCoordinate(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPosition().getY();
    }
}
