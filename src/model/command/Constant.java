package model.command;


import model.ExpressionNode;
import java.util.List;

public class Constant extends AbstractCommand{
    public Constant(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        return ownValue;
    }
}

