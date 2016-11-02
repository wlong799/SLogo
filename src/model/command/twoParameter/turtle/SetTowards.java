package model.command.twoParameter.turtle;

import dataStorage.Position;
import model.command.AbstractCommand;
import java.util.ArrayList;
import java.util.List;


public class SetTowards extends AbstractCommandTwoParameterTurtle {
    public SetTowards (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    protected double turtleExecute () {
        ArrayList<Double> operationParameters = getParameters();
        double givenX = operationParameters.get(PARAMETER_ONE);
        double givenY = operationParameters.get(PARAMETER_TWO);

        Position turtlePosition = myTurtle.getPosition();
        double turtleX = turtlePosition.getX();
        double turtleY = turtlePosition.getY();

        double oldHeading = myTurtle.getHeading();

        double newHeading = Math.toDegrees(Math.atan((givenY - turtleY) / (givenX - turtleX)));

        myTurtle.setHeading(newHeading);

        return correctOverTurns(oldHeading - newHeading);
    }
}
