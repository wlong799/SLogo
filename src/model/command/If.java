package model.command;


import model.ExpressionNode;

import java.util.List;

public class If extends AbstractCommandTwoParameter {
    // TODO FILIP: see about moving a get numTimes and getCodeblock up to AbstractCommand.
    private List<ExpressionNode> myNodes;

    public If(List<ExpressionNode> parameters) {
        super(parameters);
        myNodes = parameters;
    }

    @Override
    public double execute() {
        double returnValue = 0;

        double expr = myNodes.get(PARAMETER_ONE).getCommands().get(PARAMETER_ONE).execute();
        ExpressionNode codeBlock = myNodes.get(PARAMETER_TWO);

        if(expr != 0) {
            for(AbstractCommand command : codeBlock.getCommands()){
                returnValue = command.execute();
            }
        }

        return returnValue;
    }
}
