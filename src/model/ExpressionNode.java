package model;

import java.util.ArrayList;
import java.util.List;
import model.command.*;


public class ExpressionNode {

    private AbstractCommand myCommand;
    private List<ExpressionNode> myChildren;

    public ExpressionNode () {
        myChildren = new ArrayList<ExpressionNode>();
    }

    public ExpressionNode (AbstractCommand command, List<ExpressionNode> children) {
        myCommand = command;
        myChildren = children;
    }

    public ExpressionNode (AbstractCommand command) {
        myCommand = command;
        myChildren = new ArrayList<ExpressionNode>();
    }

    public AbstractCommand getCommand() {
        return myCommand;
    }
}
