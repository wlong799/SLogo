package model.command;

import java.util.ArrayList;
import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.TurtleStorage;

/**
 * @author Filip Mazurek
 * @author Michael Schroeder
 *
 */

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

    @Override
    public String toString () {
        StringBuilder myName = new StringBuilder();
        myName.append(this.getClass().getSimpleName());
        myName.append(" ");
        myName.append(parameterNames());
        return myName.toString();
    }
    
    protected String parameterNames () {
        StringBuilder paramNames = new StringBuilder();
        for (AbstractCommand node : myParameters) {
            paramNames.append(node.toString().trim());
            paramNames.append(" ");
        }
        return paramNames.toString();
    }

    public void addOtherParameters (DataStorageManager data, TurtleStorage turtles) {

        /**
         * Do nothing here. commands that use the variables will override to
         * set their instance variables
         */
    }

}
