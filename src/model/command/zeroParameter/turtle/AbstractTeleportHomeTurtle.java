package model.command.zeroParameter.turtle;

import dataStorage.Position;
import model.command.AbstractCommand;
import java.util.List;


public abstract class AbstractTeleportHomeTurtle extends AbstractCommandZeroParameterTurtle {
    private static final double HOME_X = 0;
    private static final double HOME_Y = 0;

    public AbstractTeleportHomeTurtle (List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double goHome () {
        System.out.println("GO HOME");
        Position turtlePos = myTurtle.getPosition();
        double turtleX = turtlePos.getX();
        double turtleY = turtlePos.getY();

        myTurtle.setPosition(new Position(HOME_X, HOME_Y));
        System.out.println(myTurtle.getPosition());
        return distanceFormula(turtleX, turtleY, HOME_X, HOME_Y);
    }
    
    
}
