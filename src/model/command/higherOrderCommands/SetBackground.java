package model.command.higherOrderCommands;

public class SetBackground extends AbstractCommandHigherOrder {

    
    
    @Override
    public double execute () {
        int index = getParameters().get(0).intValue();
        //getData().
        getData().setColor(index);
        return (double)index;
    }

    @Override
    public int getNumParameters () {
        return 1;
    }

}
