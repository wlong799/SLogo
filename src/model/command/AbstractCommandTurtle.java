package model.command;

import java.util.List;

import model.ExpressionNode;
import turtle.Turtle;

public abstract class AbstractCommandTurtle extends Command{

    Turtle oneTurtle; // TODO: get a reference to the Turtle object

	public AbstractCommandTurtle(List<ExpressionNode> parameters) {
		super(parameters);
	}

	
}
