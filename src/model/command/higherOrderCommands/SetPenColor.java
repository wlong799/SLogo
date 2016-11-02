package model.command.higherOrderCommands;

import java.util.List;
import model.command.AbstractCommand;


public class SetPenColor extends AbstractCommandHigherOrder {

    public SetPenColor (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        double penIndex = getParameters().get(0);

        getData().getColors().setPenColor((int) penIndex);
        return penIndex;
    }
    
    @Override
    public int getNumParameters () {
        return 1;
    }
}
