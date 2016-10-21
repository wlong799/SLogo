package model.command;

import model.ExpressionNode;
import java.util.List;


public class Right extends AbstractTurnTurtle {

    public Right(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return(turn(TurnDirection.Right));
    }

}