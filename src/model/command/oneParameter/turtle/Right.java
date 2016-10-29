package model.command.oneParameter.turtle;


import java.util.List;
import model.command.AbstractCommand;


public class Right extends AbstractTurnTurtle {

    public Right(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double turtleExecute () {
        return(turn(TurnDirection.Right));
    }

}
