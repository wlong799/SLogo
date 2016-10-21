package model.command;


import dataStorage.Position;
import model.ExpressionNode;

import java.util.List;

public class Towards extends AbstractCommandTwoParameterTurtle {
    public Towards(List<ExpressionNode> parameters) {
        super(parameters);
    }

    // TODO: ensure degrees are always positive

    public double execute() {
        double givenX = getParameters().get(PARAMETER_ONE);
        double givenY = getParameters().get(PARAMETER_TWO);

        Position turtlePosition = myTurtle.getPosition();
        double turtleX = turtlePosition.getX();
        double turtleY = turtlePosition.getY();

        double oldHeading = myTurtle.getHeading();

        double newHeading = Math.toDegrees(Math.atan((givenY - turtleY) / (givenX - turtleX)));

        myTurtle.setHeading(newHeading);

        return oldHeading - newHeading;
    }
}
