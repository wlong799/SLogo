package model;

import java.util.ArrayList;
import java.util.List;
import model.command.*;


public class ExpressionNode {

    private List<AbstractCommand> myCommands;

    public ExpressionNode(){
        myCommands = new ArrayList<AbstractCommand>();
    }
    public ExpressionNode (List<AbstractCommand> commands) {
        myCommands = commands;
    }

    
    public ExpressionNode (Double value){
        myCommands.add(new Constant(value));
    }

    public List<AbstractCommand> getCommands() {
        return myCommands;
    }
    
    public void addCommand(AbstractCommand command){
        myCommands.add(command);
    }


    // TODO: override a toString method to return only name of expressionNode? for making/using variables
}
