package model.command;

import model.ExpressionNode;
import java.util.List;
import dataStorage.DataStorageManager;

public class Repeat extends AbstractCommandTwoParameter {
    private static final String REPCOUNT_VAR = "repcount";
    private static final double START_REPCOUNT = 1;

    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.
    private List<ExpressionNode> myNodes;

    public Repeat(List<ExpressionNode> parameters) {
        super(parameters);
        myNodes = parameters;
    }

    /**
     * An override of execute that doesn't use the given getParamters() method. This ensures that the code block
     * given is not prematurely executed.
     *
     * @return value of the last executed command
     */
    @Override
    public double execute() {
        double numTimes = myNodes.get(PARAMETER_ONE).getCommands().get(PARAMETER_ONE).execute();

        ExpressionNode codeBlock = myNodes.get(PARAMETER_TWO);
        double returnValue = 0;

        for(double repcountVar = START_REPCOUNT; repcountVar <= numTimes; repcountVar++) {
            DataStorageManager.get().getValueVariableStorage().setVariable(REPCOUNT_VAR, repcountVar);
            for(AbstractCommand command : codeBlock.getCommands()){
                returnValue = command.execute();
            }
        }

        return returnValue;
    }


}
