package model.command;


import java.util.List;


public class ShowTurtle extends AbstractCommandZeroParameterTurtle {
    private static final double VISIBILITY_RETURN = 1;
    private static final boolean VISIBILITY_STATUS = true;

    public ShowTurtle(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        myTurtle.setVisibility(VISIBILITY_STATUS);
        return VISIBILITY_RETURN;
    }
}
