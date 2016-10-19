package model.command;


public class Constant extends AbstractCommandZeroParameter{

    private double myValue;

    public Constant(double value) {
        super();
        myValue = value;
    }

    @Override
    public double execute() {
        return myValue;
    }
}

