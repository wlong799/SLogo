package model.command;

import java.util.ArrayList;
import java.util.List;
import model.ExpressionNode;


public abstract class AbstractCommand {

    private List<AbstractCommand> myParameters;

    public AbstractCommand () {
        myParameters = new ArrayList<AbstractCommand>();
    }

    public AbstractCommand (List<AbstractCommand> parameters) {
        myParameters = parameters;
    }

    public void setParameters (List<AbstractCommand> parameters) {
        myParameters = parameters;
    }

    public abstract int getNumParameters ();

    public ArrayList<Double> getParameters () {

        ArrayList<Double> parameterList = new ArrayList<>();

        for (AbstractCommand command : myParameters) {
            parameterList.add(command.execute());
        }
        return parameterList;
    }

    public List<AbstractCommand> getRawParameters () {
        return myParameters;
    }

    public abstract double execute ();

    // TODO FILIP: See about moving this method down a class or two
    protected double distanceFormula (double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    
    @Override
    public String toString(){
        StringBuilder myName = new StringBuilder();
        
        myName.append(this.getClass().getSimpleName());
        myName.append(" ");
        for(AbstractCommand node : myParameters){
            myName.append(node.toString());
            myName.append(" ");
        }
        return myName.toString();
    }

}
