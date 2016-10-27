package model.command;

import java.util.List;



public class Backward extends AbstractMoveTurtle {

    public Backward(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return(move(MoveDirection.Backward));
    }

}
