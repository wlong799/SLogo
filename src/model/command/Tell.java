package model.command;

import model.ExpressionNode;
import java.util.ArrayList;
import java.util.List;


public class Tell extends AbstractCommandOneParameter {

    public Tell(List<ExpressionNode> parameters) {
        super(parameters);
    }

    @Override
    public double execute() {
        List<Integer> turtlesToActivate = new ArrayList<>();
        for(AbstractCommand oneParameter : getParametersAsCommands()) {

        }

        return 0;
    }


}
