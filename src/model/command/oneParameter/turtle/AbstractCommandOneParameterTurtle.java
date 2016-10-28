package model.command.oneParameter.turtle;

import java.util.List;

import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.AbstractCommandTurtle;
import model.command.oneParameter.IOneParameterCommand;

abstract class AbstractCommandOneParameterTurtle extends AbstractCommandTurtle implements IOneParameterCommand{

    protected Turtle myTurtle;

    public AbstractCommandOneParameterTurtle(List<AbstractCommand> parameters) {
        super(parameters);
        //myTurtle = DataStorageManager.get().getTurtle();
    }

    public void setTurtle(Turtle turtle){
        myTurtle = turtle;
    }

    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
