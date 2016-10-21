package model.command;


import model.ExpressionNode;

import java.util.List;

public class XCor extends AbstractCommandZeroParameterTurtle {
    public XCor(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPosition().getX();
    }
}
