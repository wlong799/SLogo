package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Pi extends AbstractCommandZeroParameter {
    public Pi(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return Math.PI;
    }
}
