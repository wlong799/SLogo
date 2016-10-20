package model.command;

import java.util.List;
import model.ExpressionNode;

public class PenUp extends AbstractCommandZeroParameterTurtle {

    public static final double PEN_UP_RETURN = 1;

    public PenUp(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        myTurtle.setPenDownStatus(false);

        return PEN_UP_RETURN;
    }
}
