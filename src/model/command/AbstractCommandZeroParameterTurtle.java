package model.command;

import java.util.List;

import dataStorage.DataStorageManager;
import model.ExpressionNode;
import dataStorage.Turtle;

public abstract class AbstractCommandZeroParameterTurtle extends AbstractCommandZeroParameter {

    protected Turtle myTurtle;

    AbstractCommandZeroParameterTurtle(List<AbstractCommand> parameters) {
        super(parameters);
        //myTurtle = DataStorageManager.get().getTurtle();
    }
    
    public void setTurtle(Turtle turtle){
        myTurtle = turtle;
    }

}
