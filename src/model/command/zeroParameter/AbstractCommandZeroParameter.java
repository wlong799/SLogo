package model.command.zeroParameter;



import java.util.List;
import model.command.AbstractCommand;

public abstract class AbstractCommandZeroParameter extends AbstractCommand implements IZeroParameterCommand{

    public AbstractCommandZeroParameter(List<AbstractCommand> parameters) {
        super(parameters);
    }
    public AbstractCommandZeroParameter() {
        super();
    }

    public int getNumParameters() {
        return NUM_PARAMETERS;
    }
}
