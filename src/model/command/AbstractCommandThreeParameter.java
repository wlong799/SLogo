package model.command;


import model.ExpressionNode;

import java.util.List;

abstract class AbstractCommandThreeParameter extends AbstractCommand {
    private static final int NUM_PARAMETERS = 3;
    static final int PARAMETER_ONE = 0;
    static final int PARAMETER_TWO = 1;
    static final int PARAMETER_THREE = 2;

    AbstractCommandThreeParameter(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}