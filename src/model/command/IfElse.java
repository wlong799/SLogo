package model.command;


import model.ExpressionNode;

import java.util.List;

public class IfElse extends AbstractCommandThreeParameter {
    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.
    private List<ExpressionNode> myNodes;

    public IfElse(List<ExpressionNode> parameters) {
        super(parameters);
        myNodes = parameters;
    }

    @Override
    public double execute() {
        double returnValue = 0;

        double expr = myNodes.get(PARAMETER_ONE).getCommands().get(PARAMETER_ONE).execute();
        ExpressionNode codeBlock1 = myNodes.get(PARAMETER_TWO);
        ExpressionNode codeBlock2 = myNodes.get(PARAMETER_THREE);

        // TODO FILIP: Pls refactor this ugliness
        if(expr != 0) {
            for(AbstractCommand command : codeBlock1.getCommands()){
                returnValue = command.execute();
            }
        }
        else {
            for(AbstractCommand command : codeBlock2.getCommands()){
                returnValue = command.execute();
            }
        }

        return returnValue;
    }
}
