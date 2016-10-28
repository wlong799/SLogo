package model.command.oneParameter.turtle;

import java.util.List;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;
import model.command.AbstractCommand;
import model.command.oneParameter.AbstractCommandOneParameter;
import dataStorage.DataStorageManager;


abstract class AbstractCommandOneParameterTurtle extends AbstractCommandOneParameter {
    private TurtleStorage myTurtles;
    protected Turtle myTurtle;
    

    public AbstractCommandOneParameterTurtle (List<AbstractCommand> parameters) {
        super(parameters);
        // myTurtle = DataStorageManager.get().getTurtle();
    }
    
    
    @Override
    public void addOtherParameters (DataStorageManager data, TurtleStorage turtles) {
        myTurtles = turtles;
    }
    
    @Override
    public double execute(){
        double output = 0.0;
        for(Turtle t : myTurtles.getActiveTurtles()){
            myTurtle = t;
            System.out.println(t.getID());
            output = turtleExecute();
        }
        return output;
    }
    
    protected abstract double turtleExecute();


}
