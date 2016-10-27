package model.command.oneParameter.turtle;


import java.util.List;
import model.command.AbstractCommand;


public class Left extends AbstractTurnTurtle {

    public Left(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return(turn(TurnDirection.Left));
    }

}
