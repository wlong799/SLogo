package model.command.higherOrderCommands;

import dataStorage.DataStorageManager;
import model.command.AbstractCommand;
import java.util.List;


public class MakeVariable extends AbstractCommandHigherOrder {
    private String myName;

    public MakeVariable (List<AbstractCommand> parameters) {
        super(parameters);
        // TODO: look at Filip comment in expression tree
        //myName = parameters.get(PARAMETER_ONE).getCommands().get(PARAMETER_ONE).toString();  // TODO:
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
        myName = getRawParameters().get(0).toString();
        List<Double> givenParameters = getParameters();
        double varValue = givenParameters.get(1);

        getData().setVariable(myName, varValue);
        System.out.println(myName +" = " + varValue);
        return varValue;
    }

    
    public int getNumParameters () {
        return 2;
    }
}
