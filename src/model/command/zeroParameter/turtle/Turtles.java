package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import model.command.zeroParameter.IZeroParameterCommand;

import java.util.List;

public class Turtles extends AbstractCommandZeroParameterTurtle implements IZeroParameterCommand {

    public Turtles (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double turtleExecute() {
        return getTurtles().getAllTurtleIDs().size();
    }
}
