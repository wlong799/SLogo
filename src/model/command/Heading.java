package model.command;

import model.ExpressionNode;
import java.util.List;


public class Heading extends AbstractCommandZeroParameterTurtle {
    public Heading(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getHeading();
    }
}