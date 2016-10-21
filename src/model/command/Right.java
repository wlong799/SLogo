package model.command;

import java.util.List;
import model.ExpressionNode;

public class Right extends AbstractCommandOneParameterTurtle {
    public Right(List<ExpressionNode> parameters) {
        super(parameters);
    }

    
    @Override
    public double execute () {
        double rotationDegrees = getParameters().get(PARAMETER_ONE);
        myTurtle.setHeading((myTurtle.getHeading()+rotationDegrees)%360.0);
        
        return rotationDegrees;
    }

}
