package model.command;

import java.util.List;
import model.ExpressionNode;
import turtle.Position;


public class Forward extends AbstractCommandOneParameterTurtle {

    public Forward(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        double myMoveDistance = getParameters().get(PARAMETER_ONE);

        double turtleHeading = oneTurtle.getHeading();

        double yMove = myMoveDistance * Math.asin(turtleHeading);
        double xMove = myMoveDistance * Math.acos(turtleHeading);

        Position prevPosition = oneTurtle.getPosition();

        Position nextPosition = new Position(prevPosition.getX() + xMove, prevPosition.getY() + yMove);

        oneTurtle.setPosition(nextPosition);

        return myMoveDistance;
    }

}
