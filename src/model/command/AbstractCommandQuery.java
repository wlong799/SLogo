package model.command;

import java.util.List;

import model.ExpressionNode;

public abstract class AbstractCommandQuery extends Command implements IZeroParameterCommand{

	public AbstractCommandQuery(List<ExpressionNode> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	public int getNumParameters() {
		return NUM_PARAMETERS;
	}
}
