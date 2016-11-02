package model.command.oneParameter.turtle;


import java.util.List;
import model.command.AbstractCommand;


public abstract class AbstractTurnTurtle extends AbstractCommandOneParameterTurtle{

    AbstractTurnTurtle(List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double turn(TurnDirection dir) {
        double givenTurnDegrees = getParameters().get(PARAMETER_ONE);
        double turnDegrees = givenTurnDegrees;

        if(dir == TurnDirection.Left) {
            turnDegrees = -1 * givenTurnDegrees;
        }

        double newHeading = myTurtle.getHeading() + turnDegrees;

        myTurtle.setHeading(correctOverTurns(newHeading));

        return givenTurnDegrees;
    }

}
