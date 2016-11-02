package model.command.higherOrderCommands;


import java.util.List;
import dataStorage.DataStorageManager;
import model.command.AbstractCommand;


public class For extends AbstractCommandHigherOrder {

    public For (List<AbstractCommand> parameters) {
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
        List<AbstractCommand> commandParams = getRawParameters();
        String repcount_var = commandParams.get(0).toString();
        List<Double> values = commandParams.get(0).getParameters();
        double start = values.get(1);
        double end =   values.get(2);
        double increment = values.get(3);

        AbstractCommand codeBlock = commandParams.get(4);

        double returnValue = 0;

        for (double repcountVar = start; repcountVar <= end; repcountVar += increment) {
            getData().setVariable(repcount_var,
                    repcountVar);
            returnValue = codeBlock.execute();
        }

        return returnValue;
    }


}
