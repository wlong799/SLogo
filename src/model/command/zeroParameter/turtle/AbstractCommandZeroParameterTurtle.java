package model.command.zeroParameter.turtle;

import java.util.List;

import dataStorage.DataStorageManager;

import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.zeroParameter.AbstractCommandZeroParameter;

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
