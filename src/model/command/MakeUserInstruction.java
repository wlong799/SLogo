package model.command;

import java.util.ArrayList;
import java.util.List;

import dataStorage.CommandVariableStorage;
import dataStorage.DataStorageManager;
import model.ExpressionNode;

// TODO FILIP: holy f I think we might need to implement scopes
// Going to do a basic implementation so we can get it working and figured out first.
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

        List<AbstractCommand> commands = getParameterNodes().get(2).getCommands();
        StringBuilder commandString = new StringBuilder();
        commandString.append("[ ");
        for(AbstractCommand oneCommand : commands) {
            commandString.append(oneCommand.toString());
        }
        commandString.append(" ]");
        CommandVariableStorage commandStorage = DataStorageManager.get().getCommandVariableStorage();

        commandStorage.setCommand(commandName, variableNames, commandString.toString());

        return 1;
    }

    @Override
    public int getNumParameters () {
        // TODO Auto-generated method stub
        return 3;
    }

}
