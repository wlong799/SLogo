package model.command;

import java.util.List;
import model.ExpressionNode;

public class PenUp extends AbstractCommandTurtle implements IZeroParameterCommand {

    public PenUp(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        oneTurtle.setPenDownStatus(false);
        return 1;
    }

    @Override
    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
