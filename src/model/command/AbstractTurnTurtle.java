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

        double newHeading = myTurtle.getHeading() + turnDegrees;

        myTurtle.setHeading(correctOverTurns(newHeading));

        return givenTurnDegrees;
    }

    protected double correctOverTurns(double degrees) {
        int overByNumTurns = 0;
        if(Math.abs(degrees) >= CIRCLE_DEGREES) {
            overByNumTurns = (int) (degrees / CIRCLE_DEGREES);
        }
        double newDegrees =  degrees - overByNumTurns * CIRCLE_DEGREES;

        if(newDegrees < 0) {
            newDegrees += CIRCLE_DEGREES;
        }
        return newDegrees;
    }

}
