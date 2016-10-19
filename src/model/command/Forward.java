package model.command;

import java.util.List;
import model.ExpressionNode;
import turtle.Position;


public class Forward extends AbstractCommandOneParameterTurtle {

//    public Forward(){
//        super(new ArrayList<ExpressionNode>());
//        System.out.println("FORWARD COMMAND WOO");
//    }

    public Forward(List<ExpressionNode> parameters) {
        super(parameters);
//        System.out.println("FORWARD COMMAND WITH VALUE " + myMoveDistance);
    }

    @Override
    public double execute () {
//        System.out.println(myMoveDistance);

        double myMoveDistance = getParameters().get(FIRST_PARAMETER);

        double turtleHeading = oneTurtle.getHeading();

        double yMove = myMoveDistance * Math.asin(turtleHeading);
        double xMove = myMoveDistance * Math.acos(turtleHeading);

        Position prevPosition = oneTurtle.getPosition();

        Position nextPosition = new Position(prevPosition.getX() + xMove, prevPosition.getY() + yMove);

        oneTurtle.setPosition(nextPosition);

        return myMoveDistance;
    }

}
