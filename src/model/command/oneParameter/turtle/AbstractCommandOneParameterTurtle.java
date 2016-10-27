package model.command.oneParameter.turtle;

import java.util.List;

import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.oneParameter.AbstractCommandOneParameter;
import dataStorage.DataStorageManager;

abstract class AbstractCommandOneParameterTurtle extends AbstractCommandOneParameter{

    protected Turtle myTurtle;

    public AbstractCommandOneParameterTurtle(List<AbstractCommand> parameters) {
        super(parameters);
        //myTurtle = DataStorageManager.get().getTurtle();
    }

    public void setTurtle(Turtle turtle){
        myTurtle = turtle;
    }
}
