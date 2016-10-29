package model.command.higherOrderCommands;

import java.util.List;
import dataStorage.*;
import model.command.AbstractCommand;


public abstract class AbstractCommandHigherOrder extends AbstractCommand{

    private CommandVariableStorage myCommands;
    private ValueVariableStorage myVariables;
    private ColorStorage myColors;
    
    public AbstractCommandHigherOrder (List<AbstractCommand> parameters) {
        super(parameters);
        // TODO Auto-generated constructor stub
    }

    public AbstractCommandHigherOrder(){
        super();
    }
    public void addVariables(ValueVariableStorage variables, CommandVariableStorage commands, ColorStorage colors){
        myCommands = commands;
        myVariables = variables;
        myColors = colors;
    }
    
    public abstract double execute();
    
    protected ValueVariableStorage getVariables(){
        return myVariables;
    }

    protected ColorStorage getColors() {
        return myColors;
    }
}
