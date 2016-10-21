package model.command;

import java.util.List;
import model.ExpressionNode;


public class Forward extends AbstractMoveTurtle {

    public Forward(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
       return(move(MoveDirection.Forward));
    }

}
