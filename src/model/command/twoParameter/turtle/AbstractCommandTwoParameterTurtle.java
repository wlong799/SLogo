package model.command.twoParameter.turtle;

import java.util.List;

import dataStorage.DataStorageManager;

import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.twoParameter.AbstractCommandTwoParameter;

public abstract class AbstractCommandTwoParameterTurtle extends AbstractCommandTwoParameter{

    protected Turtle myTurtle;

    AbstractCommandTwoParameterTurtle(List<AbstractCommand> parameters) {
        super(parameters);
        //myTurtle = DataStorageManager.get().getTurtle();
    }
    public void setTurtle(Turtle turtle){
        myTurtle = turtle;
    }
}
