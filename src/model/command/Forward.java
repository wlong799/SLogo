package model.command;

import java.util.List;



public class Forward extends AbstractMoveTurtle {

    public Forward(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
       System.out.println("move forward");
       return(move(MoveDirection.Forward));
    }

}
