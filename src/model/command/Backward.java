package model.command;

import java.util.List;
import model.ExpressionNode;


public class Backward extends AbstractMoveTurtle {

    public Backward(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return(move(MoveDirection.Backward));
    }

}
