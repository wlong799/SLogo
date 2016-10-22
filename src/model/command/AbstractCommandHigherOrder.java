package model.command;

import java.util.List;
import dataStorage.*;
import model.ExpressionNode;

public abstract class AbstractCommandHigherOrder extends AbstractCommandTwoParameter{

    private CommandVariableStorage myCommands;
    private ValueVariableStorage myVariables;
    
    public AbstractCommandHigherOrder (List<ExpressionNode> parameters) {
        super(parameters);
        // TODO Auto-generated constructor stub
    }

    public void addVariables(ValueVariableStorage variables, CommandVariableStorage commands){
        myCommands = commands;
        myVariables = variables;
    }
    
    public abstract double execute();
    
    protected ValueVariableStorage getVariables(){
        return myVariables;
    }

}
