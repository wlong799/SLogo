package model.command;

import java.util.ArrayList;
import java.util.List;
import model.ExpressionNode;

public abstract class AbstractCommand {

    private List<ExpressionNode> myNodes;
    
    AbstractCommand() {
        myNodes = null;
    }

    public void addParameters(List<ExpressionNode> parameters){
        myNodes = parameters;
    }
    public AbstractCommand(List<ExpressionNode> parameters){
        myNodes = parameters;
    }
    public void setParameters(List<ExpressionNode> parameters){
        myNodes = parameters;
    }

    public ArrayList<Double> getParameters() {

        ArrayList<Double> parameterList = new ArrayList<>();

        for (ExpressionNode oneNode : myNodes) {
            for(AbstractCommand command : oneNode.getCommands()){
                parameterList.add(command.execute());
            }
        }
        return parameterList;
    }

    public abstract double execute();


}
