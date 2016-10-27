package model.command.zeroParameter;


import java.util.ArrayList;
import java.util.List;
import model.command.AbstractCommand;


public class Pi extends AbstractCommandZeroParameter {
    public Pi(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return Math.PI;
    }
}
