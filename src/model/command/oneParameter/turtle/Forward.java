package model.command.oneParameter.turtle;

import java.util.List;
import model.command.AbstractCommand;



public class Forward extends AbstractMoveTurtle {

    public Forward(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double turtleExecute () {
       ////System.out.println("move forward");
       return(move(MoveDirection.Forward));
    }

}
