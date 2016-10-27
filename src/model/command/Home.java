package model.command;

import dataStorage.DataStorageManager;
import dataStorage.Position;
import model.ExpressionNode;
import java.util.List;
import model.command.SetPosition;


public class Home extends AbstractTeleportHomeTurtle {

    public Home(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        return goHome();
    }

}
