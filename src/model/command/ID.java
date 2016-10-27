package model.command;

import model.ExpressionNode;
import java.util.List;


public class ID extends AbstractCommandZeroParameterTurtle {
    public ID(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getID();
    }
}
