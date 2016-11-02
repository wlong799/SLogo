package model.command.higherOrderCommands;

import model.command.AbstractCommand;
import model.command.zeroParameter.turtle.AbstractCommandZeroParameterTurtle;
import java.util.List;


public class GetPenColor extends AbstractCommandHigherOrder {
    public GetPenColor (List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute () {
        return getData().getColors().getColorIndex();
    }

    @Override
    public int getNumParameters () {
        return 0;
    }
}
