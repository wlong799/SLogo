package model.command;

import java.util.List;
import dataStorage.Position;
import model.ExpressionNode;

public class Right extends AbstractCommandOneParameterTurtle {
    public Right(List<ExpressionNode> parameters) {
        super(parameters);
    }

    
    @Override
    public double execute () {
        double rotationDegreees = getParameters().get(PARAMETER_ONE);
        
        
        return 0;
    }

}
