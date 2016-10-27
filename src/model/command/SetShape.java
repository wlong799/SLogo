package model.command;

import java.util.List;
import model.ExpressionNode;


public class SetShape extends AbstractCommandOneParameterTurtle {

    public SetShape(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        double newShape = getParameters().get(PARAMETER_ONE);
        myTurtle.setShape(newShape);
        return newShape;
    }
}
