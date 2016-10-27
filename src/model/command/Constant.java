package model.command;

import java.util.List;


public class Constant extends AbstractCommandZeroParameter{

    private double myValue;

    public Constant(double value) {
        super();
        myValue = value;
    }
    
    public Constant(List<AbstractCommand> parameters) {
        super(parameters);
        myValue = parameters.get(0).execute();
    }

    
    @Override
    public double execute() {
        return myValue;
    }
    
    @Override
    public String toString() {
        return Double.toString(myValue);
    }
}

