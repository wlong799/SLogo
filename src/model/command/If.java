package model.command;




import java.util.List;

public class If extends AbstractCommandTwoParameter {
    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.

    public If(List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        double returnValue = 0;
        List<AbstractCommand> commandParams = getRawParameters();
        double expr = commandParams.get(PARAMETER_ONE).execute();
        AbstractCommand codeBlock = commandParams.get(PARAMETER_TWO);

        if(expr != 0) {
                returnValue = codeBlock.execute();
        }

        return returnValue;
    }
}
