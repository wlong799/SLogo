package model.command;

import java.util.List;
import model.ExpressionNode;


public class SetPenColor extends AbstractCommandOneParameterTurtle {

    public SetPenColor(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        double newPenColor = getParameters().get(PARAMETER_ONE);
        myTurtle.setPenColor(newPenColor);
        return newPenColor;
    }
}
