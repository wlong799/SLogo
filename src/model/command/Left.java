package model.command;


import java.util.List;


public class Left extends AbstractTurnTurtle {

    public Left(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return(turn(TurnDirection.Left));
    }

}
