package model.command;

import model.ExpressionNode;
import java.util.List;
import dataStorage.DataStorageManager;


public class DoTimes extends AbstractCommandHigherOrder {
    private static final double START_REPCOUNT = 1;

    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.

    public DoTimes (List<ExpressionNode> parameters) {
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
        double numTimes = getParameterNodes().get(0).getCommands().get(1).execute();
        String repcount_var = getParameterNodes().get(0).getCommands().get(0).toString();
        ExpressionNode codeBlock = getParameterNodes().get(1);

        double returnValue = 0;

        for (double repcountVar = START_REPCOUNT; repcountVar <= numTimes; repcountVar++) {
            getVariables().setVariable(repcount_var,
                    repcountVar);
            for (AbstractCommand command : codeBlock.getCommands()) {
                returnValue = command.execute();
            }
        }

        return returnValue;
    }

    @Override
    public int getNumParameters () {
        return 2;
    }

}
