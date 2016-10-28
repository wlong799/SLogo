package model.command;


import dataStorage.Turtle;

import java.util.List;

public abstract class AbstractCommandTurtle extends AbstractCommand {

    protected Turtle myTurtle;

    public AbstractCommandTurtle(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public void setTurtle(Turtle turtle){
        myTurtle = turtle;
    }
}
