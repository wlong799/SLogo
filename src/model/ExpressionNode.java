package model;

import java.util.ArrayList;
import java.util.List;
import model.command.*;


public class ExpressionNode {

    private Command myCommand;
    private List<ExpressionNode> myChildren;

    public ExpressionNode () {
        myChildren = new ArrayList<ExpressionNode>();
    }

    public ExpressionNode (Command command, List<ExpressionNode> children) {
        myCommand = command;
        myChildren = children;
    }

    public ExpressionNode (Command command) {
        myCommand = command;
        myChildren = new ArrayList<ExpressionNode>();
    }
}
