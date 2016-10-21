package model.command;

import model.ExpressionNode;
import java.util.List;


public class SetHeading extends AbstractTurnTurtle{

    public SetHeading(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        double givenHeading = getParameters().get(PARAMETER_ONE);

        double newHeading = correctOverTurns(givenHeading);

        double oldHeading = myTurtle.getHeading();

        myTurtle.setHeading(newHeading);

        return correctOverTurns(oldHeading - newHeading);

    }

}
