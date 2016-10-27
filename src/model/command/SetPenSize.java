package model.command;

import java.util.List;
import model.ExpressionNode;


public class SetPenSize extends AbstractCommandOneParameterTurtle {

    public SetPenSize(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        double newPenSize = getParameters().get(PARAMETER_ONE);
        myTurtle.setPenSize(newPenSize);
        return newPenSize;
    }
}
