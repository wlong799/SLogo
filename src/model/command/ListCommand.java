package model.command;

import java.util.List;


/**
 * 
 * @author Michael Schroeder
 *
 */
public class ListCommand extends AbstractCommand {

    public ListCommand (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public int getNumParameters () {
        return 1;
    }

    @Override
    public double execute () {
        double output = 0.0;
        for (AbstractCommand command : this.getRawParameters()) {
            output = command.execute();
        }
        return output;
    }

    @Override
    public String toString () {
        StringBuilder commandString = new StringBuilder();
        commandString.append("[ ");
        commandString.append(parameterNames());
        String comString = commandString.toString().trim();
        comString += " ]";
        return comString;
    }

}
