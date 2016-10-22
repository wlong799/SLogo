package model.command;

import dataStorage.Position;
import model.ExpressionNode;
import java.util.List;
import model.command.SetPosition;


public class Home extends AbstractCommandZeroParameterTurtle {
    private static final double HOME_X = 0;
    private static final double HOME_Y = 0;

    public Home(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        Position turtlePos = myTurtle.getPosition();
        double turtleX = turtlePos.getX();
        double turtleY = turtlePos.getY();

        myTurtle.setPosition(new Position(HOME_X, HOME_Y));
        return distanceFormula(turtleX, turtleY, HOME_X, HOME_Y);
    }

}
