package model.command;

import java.util.List;

import model.ExpressionNode;

public class PenUp extends TurtleCommand implements IZeroParameterCommand {

	public PenUp(List<ExpressionNode> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumParameters() {
		return NUM_PARAMETERS;
	}
}
