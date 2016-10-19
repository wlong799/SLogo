package model.command;

import java.util.ArrayList;
import java.util.List;
import model.ExpressionNode;

public abstract class Command {

    private List<ExpressionNode> myNodes;

    public Command(List<ExpressionNode> parameters){
        myNodes = parameters;
    }

    public ArrayList<Double> getParameters() {

        ArrayList<Double> parameterList = new ArrayList<>();

        for (ExpressionNode oneNode : myNodes) {
            parameterList.add(oneNode.getCommand().execute());
        }
        return parameterList;
    }

    public abstract double execute();

}
