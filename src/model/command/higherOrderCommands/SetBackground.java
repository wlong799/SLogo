package model.command.higherOrderCommands;

import java.util.List;
import model.command.AbstractCommand;

public class SetBackground extends AbstractCommandHigherOrder {

    public SetBackground (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        int index = getParameters().get(0).intValue();
        ////System.out.println("set color " + index);
        getData().setBackgroundColor(index);
        return (double) index;
    }

    @Override
    public int getNumParameters () {
        return 1;
    }

}
