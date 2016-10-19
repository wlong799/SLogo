package model.command;

import java.util.List;
import model.ExpressionNode;
import dataStorage.Turtle;
import dataStorage.DataStorageManager;

abstract class AbstractCommandOneParameterTurtle extends AbstractCommandOneParameter{

    Turtle myTurtle;

    AbstractCommandOneParameterTurtle(List<ExpressionNode> parameters) {
        super(parameters);
        myTurtle = DataStorageManager.get().getTurtle();
    }

}
