package model.command;

import dataStorage.DataStorageManager;
import dataStorage.Position;

import java.util.List;
import model.command.SetPosition;


public class ClearScreen extends AbstractTeleportHomeTurtle {

    public ClearScreen(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        double distance = goHome();
        DataStorageManager.get().getNotifications().setClearScreenFlag();
        return distance;
    }

}
