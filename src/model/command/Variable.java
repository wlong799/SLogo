package model.command;

import java.util.List;
import model.ExpressionNode;


public class Variable extends AbstractCommandHigherOrder {

    private String myVariableName;

    public Variable (String name) {
        super();
        myVariableName = name;
    }

    public Variable (List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public String toString () {
        return myVariableName;
    }

    @Override
    public double execute () {
        return getVariables().getVariable(myVariableName);
    }

    @Override
    public int getNumParameters () {
        return 0;
    }

}
