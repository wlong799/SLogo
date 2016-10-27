package model.command;

import dataStorage.Position;
import model.ExpressionNode;
import java.util.List;


abstract class AbstractMoveTurtle extends AbstractCommandOneParameterTurtle {

    AbstractMoveTurtle(List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double move (MoveDirection dir) {
        double givenMoveDistance = getParameters().get(PARAMETER_ONE);

        double directionDistance = givenMoveDistance;

        if(dir == MoveDirection.Backward) {
            directionDistance = -givenMoveDistance;
        }

        double turtleHeading = Math.toRadians(myTurtle.getHeading());

        double yMove = directionDistance * Math.sin(turtleHeading);
        double xMove = directionDistance * Math.cos(turtleHeading);

        Position prevPosition = myTurtle.getPosition();

        Position nextPosition = new Position(prevPosition.getX() + xMove, prevPosition.getY() + yMove);

        myTurtle.setPosition(nextPosition);

        return givenMoveDistance;
    }
}
