package model.command;

import java.util.ArrayList;
import java.util.List;
import model.ExpressionNode;

public abstract class Command {

    public Command(List<ExpressionNode> parameters){
        
    }
    
    public abstract double execute();
}
