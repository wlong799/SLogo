package model.command.threeParameter;


import java.util.List;
import model.command.AbstractCommand;


public class IfElse extends AbstractCommandThreeParameter {

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

        returnValue = expr != 0 ? codeBlock1.execute() : codeBlock2.execute();

        return returnValue;
    }
}
