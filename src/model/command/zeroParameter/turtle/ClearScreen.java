package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.TurtleStorage;


public class ClearScreen extends AbstractTeleportHomeTurtle {

    private DataStorageManager myData;

    public ClearScreen (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public void addOtherParameters (DataStorageManager data, TurtleStorage turtles) {
        setTurtleStorage(turtles);
        myData = data;
    }

    @Override
    protected double turtleExecute () {
        boolean penDown = myTurtle.getPenDownStatus();
        myTurtle.setPenDownStatus(false);
        ////System.out.println("CLEAR SCREEN");
        double distance = goHome();
        myData.getNotifications().setClearScreenFlag();
        myTurtle.setHeading(-90);

        // myTurtle.setPenDownStatus(penDown);
        // somehow tell front end to clear the screen
        return distance;
    }

}
