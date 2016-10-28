package model.command.zeroParameter.turtle;


import java.util.List;
import model.command.AbstractCommand;


public class Heading extends AbstractCommandZeroParameterTurtle {
    public Heading(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getHeading();
    }
}
