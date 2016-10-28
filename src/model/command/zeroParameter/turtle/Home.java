package model.command.zeroParameter.turtle;

import dataStorage.DataStorageManager;
import dataStorage.Position;
import model.command.AbstractCommand;
import model.command.twoParameter.turtle.SetPosition;
import java.util.List;


public class Home extends AbstractTeleportHomeTurtle {

    public Home(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return goHome();
    }

}
