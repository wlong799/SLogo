package model.command;

import java.util.ArrayList;
import java.util.List;


public class ForwardCommand extends Command {

    private double value;
    
    public ForwardCommand(){
        super(new ArrayList<Integer>());
        System.out.println("FORWRAD COMMAND WOO");
    }
    public ForwardCommand (List<Integer> params) {
        super(params);
        this.value = params.get(0);
        System.out.println("FORWARD COMMAND WITH VALUE " + value);
    }

    @Override
    public void execute () {
        // TODO Auto-generated method stub
        System.out.println(value);
    }

}
