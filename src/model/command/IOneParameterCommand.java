package model.command;

public interface IOneParameterCommand {
	public static final int NUM_PARAMETERS = 1;
    public static final int FIRST_PARAMETER = 0;

	int getNumParameters();
}
