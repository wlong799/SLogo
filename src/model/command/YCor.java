package model.command;

import model.ExpressionNode;
import java.util.List;


public class YCor extends AbstractCommandZeroParameterTurtle {
    public YCor(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPosition().getY();
    }
}
