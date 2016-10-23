package model.command;

import java.util.ArrayList;
import java.util.List;
import model.ExpressionNode;

public abstract class AbstractCommand {

    private List<ExpressionNode> myNodes;
    
    public AbstractCommand() {
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
    public List<AbstractCommand> getParametersAsCommands() {
        ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
        myNodes.forEach(command -> commands.addAll(command.getCommands()));
        return commands;
    }
    public abstract int getNumParameters();
    
    public ArrayList<Double> getParameters() {

        ArrayList<Double> parameterList = new ArrayList<>();

        for (ExpressionNode oneNode : myNodes) {
            for(AbstractCommand command : oneNode.getCommands()){
                parameterList.add(command.execute());
            }
        }
        return parameterList;
    }

    public List<ExpressionNode> getParameterNodes() {
        return myNodes;
    }

    public abstract double execute();

    // TODO FILIP: See about moving this method down a class or two
    protected double distanceFormula(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

}
