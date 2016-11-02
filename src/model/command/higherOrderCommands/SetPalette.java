package model.command.higherOrderCommands;

import model.command.AbstractCommand;
import model.command.fourParameter.IFourParameterCommand;
import java.util.ArrayList;
import java.util.List;


public class SetPalette extends AbstractCommandHigherOrder implements IFourParameterCommand {
    private static final int MIN_COLOR_VALUE = 0;
    private static final int MAX_COLOR_VALUE = 256;

    public SetPalette (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public double execute () {
        ArrayList<Double> parameterValues = getParameters();
        int index = parameterValues.get(PARAMETER_ONE).intValue();
        int red = parameterValues.get(PARAMETER_TWO).intValue();
        int green = parameterValues.get(PARAMETER_THREE).intValue();
        int blue = parameterValues.get(PARAMETER_FOUR).intValue();

        ////System.out.println("adding palette");
        if (!(isValidColor(red) && isValidColor(green) && isValidColor(blue))) {
            // // TODO: set an invalid color range flag in Notifications
            // // TODO: getNotifications().setColorFlag();
            return index; // so we can keep going. Shouldn't be program-breaking
        }

        getData().addColor(index, red, green, blue);

        return index;
    }

    public int getNumParameters () {
        return NUM_PARAMETERS;
    }

    private boolean isValidColor (int color) {
        return (color >= MIN_COLOR_VALUE) && (color < MAX_COLOR_VALUE);
    }
}
