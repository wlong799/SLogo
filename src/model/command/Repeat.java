package model.command;

import model.ExpressionNode;
import java.util.List;
import dataStorage.DataStorageManager;


public class Repeat extends AbstractCommandHigherOrder {
    private static final String REPCOUNT_VAR = "repcount";
    private static final double START_REPCOUNT = 1;

    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.

    public Repeat (List<AbstractCommand> parameters) {
        super(parameters);
    }

    /**
     * An override of execute that doesn't use the given getParamters() method. This ensures that
     * the code block
     * given is not prematurely executed.
     *
     * @return value of the last executed command
     */
    @Override
    public double execute () {
        double numTimes = getRawParameters().get(0).execute();
        
        AbstractCommand command = getRawParameters().get(1);
        //ExpressionNode codeBlock = myNodes.get(1);
        double returnValue = 0;

        for (double repcountVar = START_REPCOUNT; repcountVar <= numTimes; repcountVar++) {
            getVariables().setVariable(REPCOUNT_VAR,
                                                                           repcountVar);
            returnValue = command.execute();
        }

        return returnValue;
    }

    @Override
    public int getNumParameters () {
        return 2;
    }

}
