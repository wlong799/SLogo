package model.command.higherOrderCommands;

import model.command.zeroParameter.IZeroParameterCommand;

public class Turtles extends AbstractCommandHigherOrder implements IZeroParameterCommand {

    public double execute() {
        return getTurtles().getAllTurtleIDs().size();
    }
}
