package model.command;

import java.util.List;
import model.ExpressionNode;
import dataStorage.Turtle;
import dataStorage.DataStorageManager;

abstract class AbstractCommandOneParameterTurtle extends AbstractCommandOneParameter{

    protected Turtle myTurtle;

    public AbstractCommandOneParameterTurtle(List<ExpressionNode> parameters) {
        super(parameters);
        //myTurtle = DataStorageManager.get().getTurtle();
    }

    public void setTurtle(Turtle turtle){
        myTurtle = turtle;
    }
}
