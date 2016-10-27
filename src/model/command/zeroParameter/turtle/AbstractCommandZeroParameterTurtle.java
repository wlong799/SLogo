package model.command.zeroParameter.turtle;

import java.util.ArrayList;
import java.util.List;

import dataStorage.DataStorageManager;

import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.zeroParameter.AbstractCommandZeroParameter;

public abstract class AbstractCommandZeroParameterTurtle extends AbstractCommandZeroParameter {

    private static final double NO_TURTLE_RESULT = 0;
    protected Turtle myTurtle;

    AbstractCommandZeroParameterTurtle(List<AbstractCommand> parameters) {
        super(parameters);
        //myTurtle = DataStorageManager.get().getTurtle();
    }

    // TODO: an Idea... but look into just calling all the commands from the top level
    // Same method call for all parameter turtle commands
//    @Override
//    public ArrayList<Double> getParameters() {
//
//        ArrayList<Double> parameterList = new ArrayList<>();
//
//        for (ExpressionNode oneNode : getParameterNodes()) {
//            for(AbstractCommand command : oneNode.getCommands()){
//                double lastResult = NO_TURTLE_RESULT;
//                for(Turtle oneActiveTurtle : DataStorageManager.get().getActiveTurtles()) {
//                    setTurtle(oneActiveTurtle);
//                    lastResult = command.execute();
//                }
//                parameterList.add(lastResult);
//            }
//        }
//        return parameterList;
//    }

    private void setTurtle(Turtle turtle){
        myTurtle = turtle;
    }

}
