package model.command;

import model.ExpressionNode;
import java.util.List;
import dataStorage.DataStorageManager;


public class For extends AbstractCommandHigherOrder {

    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.

    public For (List<ExpressionNode> parameters) {
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
        String repcount_var = getParameterNodes().get(0).getCommands().get(0).toString();

        double start = getParameterNodes().get(0).getCommands().get(1).execute();
        double end =   getParameterNodes().get(0).getCommands().get(2).execute();
        double increment = getParameterNodes().get(0).getCommands().get(3).execute();

        ExpressionNode codeBlock = getParameterNodes().get(1);

        double returnValue = 0;

        for (double repcountVar = start; repcountVar <= end; repcountVar += increment) {
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
