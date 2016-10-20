package model.command;

import java.util.List;
import model.ExpressionNode;

public class LessThan extends AbstractCommandTwoParameter{
    private static final double TRUE_RESULT = 1;
    private static final double FALSE_RESULT = 0;

	public LessThan(List<ExpressionNode> parameters) {
		super(parameters);
	}
	
	@Override
	public double execute() {
		List<Double> givenParameters = getParameters();

        return givenParameters.get(PARAMETER_ONE) < givenParameters.get(PARAMETER_TWO) ?
                TRUE_RESULT : FALSE_RESULT;
	}

}
