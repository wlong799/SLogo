package model.command;

import java.util.List;

import dataStorage.DataStorageManager;

import dataStorage.Turtle;

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
