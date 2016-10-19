package model.command;

import java.util.List;

import model.ExpressionNode;

public class LessP extends AbstractCommandBoolean implements ITwoParameterCommand {

	public LessP(List<ExpressionNode> parameters) {
		super(parameters);
	}

	
	@Override
	public double execute() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getNumParameters() {
		return NUM_PARAMETERS;
	}

}
