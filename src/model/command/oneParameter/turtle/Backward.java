package model.command.oneParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;



public class Backward extends AbstractMoveTurtle {

    public Backward(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double turtleExecute () {
        return(move(MoveDirection.Backward));
    }

}
