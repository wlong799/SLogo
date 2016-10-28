package model.command.higherOrderCommands;

import java.util.List;
import dataStorage.*;
import model.command.AbstractCommand;


public abstract class AbstractCommandHigherOrder extends AbstractCommand{

    private CommandVariableStorage myCommands;
    private ValueVariableStorage myVariables;
    
    public AbstractCommandHigherOrder (List<AbstractCommand> parameters) {
        super(parameters);
        // TODO Auto-generated constructor stub
    }

    public AbstractCommandHigherOrder(){
        super();
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
