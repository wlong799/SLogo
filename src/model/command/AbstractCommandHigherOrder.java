package model.command;

import java.util.List;
import model.ExpressionNode;

public abstract class AbstractCommandHigherOrder extends AbstractCommandTwoParameter{

    public AbstractCommandHigherOrder (List<ExpressionNode> parameters) {
        super(parameters);
        // TODO Auto-generated constructor stub
    }

    public abstract double execute();

}
