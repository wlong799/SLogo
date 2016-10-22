package model.command;


import model.ExpressionNode;

import java.util.List;

public class XCoordinate extends AbstractCommandZeroParameterTurtle {
    public XCoordinate(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPosition().getX();
    }
}
