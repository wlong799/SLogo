package model.command;

import java.util.List;
import model.ExpressionNode;
import dataStorage.Position;
import dataStorage.Turtle;


public class Forward extends AbstractCommandOneParameterTurtle {

    public Forward(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        double myMoveDistance = getParameters().get(PARAMETER_ONE);

        double turtleHeading = Math.toRadians(myTurtle.getHeading());
        System.out.println(turtleHeading);
        double yMove = myMoveDistance * Math.sin(turtleHeading);
        double xMove = myMoveDistance * Math.cos(turtleHeading);

        Position prevPosition = myTurtle.getPosition();

        Position nextPosition = new Position(prevPosition.getX() + xMove, prevPosition.getY() + yMove);

        myTurtle.setPosition(nextPosition);

        return myMoveDistance;
    }

}
