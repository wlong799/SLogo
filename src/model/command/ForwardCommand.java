package model.command;

import java.util.ArrayList;
import java.util.List;
import model.ExpressionNode;
import turtle.Position;


public class ForwardCommand extends AbstractCommandTurtle implements IOneParameterCommand {

    private double myMoveDistance;
    private ExpressionNode first_parameter;
    
//    public ForwardCommand(){
//        super(new ArrayList<ExpressionNode>());
//        System.out.println("FORWARD COMMAND WOO");
//    }

    public ForwardCommand (List<ExpressionNode> parameters) {
        super(parameters);
        first_parameter = parameters.get(FIRST_PARAMETER);
        System.out.println("FORWARD COMMAND WITH VALUE " + myMoveDistance);
    }

    @Override
    public double execute () {
        System.out.println(myMoveDistance);

        myMoveDistance = executeParameter(first_parameter);

        double turtleHeading = oneTurtle.getHeading();

        double yMove = myMoveDistance * Math.asin(turtleHeading);
        double xMove = myMoveDistance * Math.acos(turtleHeading);

        Position prevPosition = oneTurtle.getPosition();

        Position nextPosition = new Position(prevPosition.getX() + xMove, prevPosition.getY() + yMove);

        oneTurtle.setPosition(nextPosition);

        return myMoveDistance;
    }

    public double executeParameter(ExpressionNode oneNode) { // TODO: maybe not implement the interface so can be private
        return oneNode.getCommand().execute(); // TODO: this is what I need here, execute like this?
    }

    public int getNumParameters() {
        return NUM_PARAMETERS;
    }

}
