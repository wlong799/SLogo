package model.command;


import dataStorage.DataStorageManager;
import model.ExpressionNode;

import java.util.List;

public class Make extends AbstractCommandTwoParameter {
    private String myName;

    Make(List<ExpressionNode> parameters) {
        super(parameters);
        // TODO: look at Filip comment in expression tree
        myName = parameters.get(PARAMETER_ONE).getCommand().toString();  // TODO: make a toString method to return only name
    }

    @Override
    public double execute() {
        List<Double> givenParameters = getParameters();
        double varValue = givenParameters.get(PARAMETER_TWO);

        DataStorageManager.get().getValueVariableStorage().setVariable(myName, varValue);

        return varValue;
    }
}
