package model.command;

import model.ExpressionNode;
import java.util.List;


public class HideTurtle extends AbstractCommandZeroParameterTurtle {
    private static final double VISIBILITY_RETURN = 0;
    private static final boolean VISIBILITY_STATUS = false;

    public HideTurtle(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        myTurtle.setVisibility(VISIBILITY_STATUS);
        return VISIBILITY_RETURN;
    }
}
