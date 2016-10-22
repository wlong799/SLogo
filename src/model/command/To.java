package model.command;

import java.util.List;
import model.ExpressionNode;

// TODO FILIP: holy f I think we might need to implement scopes
// Going to do a basic implementation so we can get it working and figured out first.
public class To extends AbstractCommandHigherOrder{

    public To (List<ExpressionNode> parameters) {
        super(parameters);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }

}
