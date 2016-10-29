package model.command.higherOrderCommands;

import java.util.List;
import dataStorage.DataStorageManager;
import model.command.AbstractCommand;


public class DoTimes extends AbstractCommandHigherOrder {
    private static final double START_REPCOUNT = 1;

    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.

    public DoTimes (List<AbstractCommand> parameters) {
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
        double numTimes = getRawParameters().get(1).execute();
        String repcount_var = getRawParameters().get(0).toString();
        List<AbstractCommand> codeBlock = getRawParameters().subList(2, getRawParameters().size());

        double returnValue = 0;

        for (double repcountVar = START_REPCOUNT; repcountVar <= numTimes; repcountVar++) {
            getData().setVariable(repcount_var,
                                  repcountVar);
            for (AbstractCommand command : codeBlock) {
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
