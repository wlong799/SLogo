package model.command;

import java.util.List;

public class ListCommand extends AbstractCommand {
    
    
    public ListCommand(List<AbstractCommand> parameters){
        super(parameters);
    }
    @Override
    public int getNumParameters () {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public double execute () {
        double output = 0.0;
        for(AbstractCommand command : this.getRawParameters()){
            output = command.execute();
        }
        return output;
    }
    @Override
    public String toString() {
        List<AbstractCommand> commands = this.getRawParameters();

        StringBuilder commandString = new StringBuilder();
        commandString.append("[ ");
        for(AbstractCommand oneCommand : commands) {
            commandString.append(oneCommand.toString());
        }
      
        commandString.append(" ]");

        return commandString.toString();
    }

}
