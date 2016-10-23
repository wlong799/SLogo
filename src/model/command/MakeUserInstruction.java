package model.command;

import java.util.ArrayList;
import java.util.List;

import dataStorage.CommandVariableStorage;
import dataStorage.DataStorageManager;
import model.ExpressionNode;


public class MakeUserInstruction extends AbstractCommandHigherOrder{

    public MakeUserInstruction (List<ExpressionNode> parameters) {
        super(parameters);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        String commandName = getParametersAsCommands().get(0).toString();

        List<AbstractCommand> variables = getParameterNodes().get(1).getCommands();
        List<String> variableNames = new ArrayList<>();
        for(AbstractCommand oneCommand : variables) {
            variableNames.add(oneCommand.toString());
        }


        String commandString = getParameterNodes().get(2).toString();
        CommandVariableStorage commandStorage = DataStorageManager.get().getCommandVariableStorage();

        commandStorage.setCommand(commandName, variableNames, commandString);

        return 1;
    }

    @Override
    public int getNumParameters () {
        // TODO Auto-generated method stub
        return 3;
    }

}
