package model.command;

import java.util.ArrayList;
import java.util.List;
import model.ExpressionNode;


public class ForwardCommand extends Command {

    private double value;
    
    public ForwardCommand(){
        super(new ArrayList<ExpressionNode>());
        System.out.println("FORWRAD COMMAND WOO");
    }
    public ForwardCommand (List<ExpressionNode> params) {
        super(params);
        //this.value = params.get(0);
        System.out.println("FORWARD COMMAND WITH VALUE " + value);
    }

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        System.out.println(value);
    }

}
