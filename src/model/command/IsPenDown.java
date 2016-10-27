package model.command;


import java.util.List;


public class IsPenDown extends AbstractCommandZeroParameterTurtle {
    private static final double RETURN_PENDOWN = 1;
    private static final double RETURN_PENUP = 0;

    public IsPenDown(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return myTurtle.getPenDownStatus() ? RETURN_PENDOWN : RETURN_PENUP;
    }
}
