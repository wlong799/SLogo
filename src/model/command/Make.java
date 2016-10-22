package model.command;

import dataStorage.DataStorageManager;
import model.ExpressionNode;
import java.util.List;


public class Make extends AbstractCommandHigherOrder {
    private String myName;

    public Make (List<ExpressionNode> parameters) {
        super(parameters);
        // TODO: look at Filip comment in expression tree
        myName = parameters.get(PARAMETER_ONE).getCommands().get(PARAMETER_ONE).toString();  // TODO:
                                                                                             // make
                                                                                             // a
                                                                                             // toString
                                                                                             // method
                                                                                             // to
                                                                                             // return
                                                                                             // only
                                                                                             // name
    }

    @Override
    public double execute () {
        List<Double> givenParameters = getParameters();
        double varValue = givenParameters.get(PARAMETER_TWO);

        getVariables().setVariable(myName, varValue);

        return varValue;
    }

    public int getNumParameters () {
        return 2;
    }
}
