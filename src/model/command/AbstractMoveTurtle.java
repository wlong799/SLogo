package model.command;

import dataStorage.Position;

import java.util.List;


abstract class AbstractMoveTurtle extends AbstractCommandOneParameterTurtle {

    AbstractMoveTurtle (List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double move (MoveDirection dir) {
        double givenMoveDistance = getParameters().get(PARAMETER_ONE);

        double directionDistance =
                dir == MoveDirection.Backward ? -givenMoveDistance : givenMoveDistance;

        double turtleHeading = Math.toRadians(myTurtle.getHeading());

        double yMove = directionDistance * Math.sin(turtleHeading);
        double xMove = directionDistance * Math.cos(turtleHeading);

        Position prevPosition = myTurtle.getPosition();

        Position nextPosition =
                new Position(prevPosition.getX() + xMove, prevPosition.getY() + yMove);

        myTurtle.setPosition(nextPosition);
        System.out.println(dir + " " + givenMoveDistance);
        return givenMoveDistance;
    }
}
