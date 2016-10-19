package model.command;

import java.util.List;

import dataStorage.DataStorageManager;
import model.ExpressionNode;
import dataStorage.Turtle;

abstract class AbstractCommandTwoParameterTurtle extends AbstractCommandTwoParameter{

    Turtle myTurtle;

    AbstractCommandTwoParameterTurtle(List<ExpressionNode> parameters) {
        super(parameters);
        myTurtle = DataStorageManager.get().getTurtle();
    }
}
