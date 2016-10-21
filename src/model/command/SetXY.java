package model.command;


import dataStorage.Position;
import model.ExpressionNode;

import java.util.List;

public class SetXY extends AbstractCommandTwoParameterTurtle {
    public SetXY(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        double givenX = getParameters().get(PARAMETER_ONE);
        double givenY = getParameters().get(PARAMETER_TWO);

        Position turtlePos = myTurtle.getPosition();
        double turtleX = turtlePos.getX();
        double turtleY = turtlePos.getY();

        myTurtle.setPosition(new Position(givenX, givenY));

        return distanceFormula(givenX, givenY, turtleX, turtleY);
    }
}
