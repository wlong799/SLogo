package model.command;

import java.util.List;
import model.ExpressionNode;

public class Constant extends AbstractCommandZeroParameter{

    private double myValue;

    public Constant(double value) {
        super();
        myValue = value;
    }
    
    public Constant(List<ExpressionNode> parameters) {
        super(parameters);
        myValue = parameters.get(0).getCommands().get(0).execute();
    }

    // TODO FILIP: isn't this overkill as all constants should have zero parameters?

    @Override
    public void addParameters(List<ExpressionNode> parameters){
        myValue = parameters.get(0).getCommands().get(0).execute();
    }
    
    @Override
    public double execute() {
        return myValue;
    }
}

