package model.command;


import model.ExpressionNode;

import java.util.List;

public abstract class AbstractCommandOneParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 1;
    public static final int FIRST_PARAMETER = 0;

    AbstractCommandOneParameter(List<ExpressionNode> parameters) {
        super(parameters);
    }

    int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
