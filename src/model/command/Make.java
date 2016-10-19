package model.command;


import dataStorage.DataStorageManager;
import model.ExpressionNode;

import java.util.List;

public class Make extends AbstractCommandTwoParameter {
    private String myName;

    Make(List<ExpressionNode> parameters) {
        super(parameters);
        myName = parameters.get(PARAMETER_ONE).toString();
    }

    @Override
    public double execute() {
        List<Double> givenParameters = getParameters();
        double varValue = givenParameters.get(PARAMETER_TWO);

        DataStorageManager.get().getVariableStorage().setVariable(myName, varValue);

        return varValue;
    }
}
