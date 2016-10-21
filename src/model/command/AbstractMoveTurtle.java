package model.command;

import dataStorage.Position;
import model.ExpressionNode;
import java.util.List;


abstract class AbstractMoveTurtle extends AbstractCommandOneParameterTurtle {

    AbstractMoveTurtle(List<ExpressionNode> parameters) {
        super(parameters);
    }

    protected double move (MoveDirectionEnum dir) {
        double givenMoveDistance = getParameters().get(PARAMETER_ONE);

        double directionDistance = givenMoveDistance;

        if(dir == MoveDirectionEnum.Backward) {
            directionDistance = -givenMoveDistance;
        }

        double turtleHeading = myTurtle.getHeading();

        double yMove = directionDistance * Math.sin(turtleHeading);
        double xMove = directionDistance * Math.cos(turtleHeading);

        Position prevPosition = myTurtle.getPosition();

        Position nextPosition = new Position(prevPosition.getX() + xMove, prevPosition.getY() + yMove);

        myTurtle.setPosition(nextPosition);

        return givenMoveDistance;
    }
}
