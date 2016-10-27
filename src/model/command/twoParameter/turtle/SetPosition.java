package model.command.twoParameter.turtle;


import dataStorage.Position;
import model.command.AbstractCommand;
import java.util.ArrayList;
import java.util.List;

public class SetPosition extends AbstractCommandTwoParameterTurtle {
    public SetPosition(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        ArrayList<Double> operationParameters = getParameters();
        double givenX = operationParameters.get(PARAMETER_ONE);
        double givenY = operationParameters.get(PARAMETER_TWO);

        Position turtlePos = myTurtle.getPosition();
        double turtleX = turtlePos.getX();
        double turtleY = turtlePos.getY();

        myTurtle.setPosition(new Position(givenX, givenY));

        return distanceFormula(givenX, givenY, turtleX, turtleY);
    }
}
