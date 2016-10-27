package model.command;

import model.ExpressionNode;
import java.util.List;


public class GetPenColor extends AbstractCommandZeroParameterTurtle {
    public GetPenColor(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPenColor();
    }
}
