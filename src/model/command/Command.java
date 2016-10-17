package model.command;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    public Command(List<Integer> parameters){
        
    }
    
    public abstract void execute();
}
