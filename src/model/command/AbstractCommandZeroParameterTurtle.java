package model.command;

import java.util.List;

import dataStorage.DataStorageManager;
import model.ExpressionNode;
import dataStorage.Turtle;

abstract class AbstractCommandZeroParameterTurtle extends AbstractCommandZeroParameter {

    Turtle myTurtle;

    AbstractCommandZeroParameterTurtle(List<ExpressionNode> parameters) {
        super(parameters);
        myTurtle = DataStorageManager.get().getTurtle();
    }

}
