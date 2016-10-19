package model.command;

import java.util.List;

import model.ExpressionNode;
import turtle.Turtle;

public abstract class AbstractCommandOneParameterTurtle extends AbstractCommandOneParameter {

    Turtle oneTurtle; // TODO: get a reference to the Turtle object

	AbstractCommandOneParameterTurtle(List<ExpressionNode> parameters) {
		super(parameters);
	}

	
}
