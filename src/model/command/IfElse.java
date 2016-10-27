package model.command;


import java.util.List;


public class IfElse extends AbstractCommandThreeParameter {
    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.

    public IfElse (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        double returnValue = 0;
        List<AbstractCommand> commandParams = getRawParameters();
        double expr = commandParams.get(PARAMETER_ONE).execute();
        AbstractCommand codeBlock1 = commandParams.get(PARAMETER_TWO);
        AbstractCommand codeBlock2 = commandParams.get(PARAMETER_THREE);

        // TODO FILIP: Pls refactor this ugliness
        // MICHAEL: refactored the ugliness
        returnValue = expr != 0 ? codeBlock1.execute() : codeBlock2.execute();

        return returnValue;
    }
}
