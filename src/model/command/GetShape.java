package model.command;

import model.ExpressionNode;
import java.util.List;


public class GetShape extends AbstractCommandZeroParameterTurtle {
    public GetShape(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getShape();
    }
}
