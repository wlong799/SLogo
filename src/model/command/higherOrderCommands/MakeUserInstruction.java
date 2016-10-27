package model.command.higherOrderCommands;

import java.util.ArrayList;
import java.util.List;
import dataStorage.CommandVariableStorage;
import dataStorage.DataStorageManager;
import model.command.AbstractCommand;


public class MakeUserInstruction extends AbstractCommandHigherOrder {

    public MakeUserInstruction (List<AbstractCommand> parameters) {
        super(parameters);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        String commandName = getRawParameters().get(0).toString();

        List<AbstractCommand> variables = getRawParameters().get(1).getRawParameters();
        List<String> variableNames = new ArrayList<>();
        for (AbstractCommand oneCommand : variables) {
            variableNames.add(oneCommand.toString());
        }

        String commandString = getRawParameters().get(2).toString();

        CommandVariableStorage commandStorage =
                DataStorageManager.get().getCommandVariableStorage();

        commandStorage.setCommand(commandName, variableNames, commandString);
        System.out.println("Command string " + commandString);
        return 1;
    }

    @Override
    public int getNumParameters () {
        // TODO Auto-generated method stub
        return 3;
    }

}
