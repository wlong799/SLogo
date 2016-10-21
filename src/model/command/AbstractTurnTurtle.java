package model.command;

import model.ExpressionNode;
import java.util.List;


abstract class AbstractTurnTurtle extends AbstractCommandOneParameterTurtle{
    private static final double CIRCLE_DEGREES = 360;

    AbstractTurnTurtle(List<ExpressionNode> parameters) {
        super(parameters);
    }

    protected double turn(TurnDirection dir) {
        double givenTurnDegrees = getParameters().get(PARAMETER_ONE);
        double turnDegrees = givenTurnDegrees;

        if(dir == TurnDirection.Right) {
            turnDegrees = -givenTurnDegrees;
        }

        turnDegrees = correctOverTurns(turnDegrees);

        double newHeading = myTurtle.getHeading() + turnDegrees;

        myTurtle.setHeading(correctOverTurns(newHeading));

        return givenTurnDegrees;
    }

    private double correctOverTurns(double degrees) {
        int overByNumTurns = 0;
        if(Math.abs(degrees) >= CIRCLE_DEGREES) {
            overByNumTurns = (int) (degrees / CIRCLE_DEGREES);
        }
        return degrees - overByNumTurns * CIRCLE_DEGREES;
    }

}
