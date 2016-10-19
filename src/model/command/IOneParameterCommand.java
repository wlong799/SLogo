package model.command;

public interface IOneParameterCommand extends IParameterCommand {
	public static final int NUM_PARAMETERS = 1;
    public static final int FIRST_PARAMETER = 0;

	int getNumParameters();
}
