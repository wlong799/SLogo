package model.command;

import model.ExpressionNode;
import java.util.List;


public class Left extends AbstractTurnTurtle {

    public Left(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        return(turn(TurnDirection.Left));
    }

}