package model.command;

import java.util.List;
import model.ExpressionNode;


public class Back extends AbstractMoveTurtle {

    public Back(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return(move(MoveDirection.Backward));
    }

}
