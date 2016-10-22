package model.command;

import model.ExpressionNode;
import java.util.List;


public class PenDownP extends AbstractCommandZeroParameterTurtle {
    private static final double RETURN_PENDOWN = 1;
    private static final double RETURN_PENUP = 0;

    public PenDownP(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPenDownStatus() ? RETURN_PENDOWN : RETURN_PENUP;
    }
}
