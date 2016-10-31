package view.toolbar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class CommandHelpInfo extends MenuElement {
    private static final String NAME = "Command Help";

    private MenuItem myMenuItem;

    public CommandHelpInfo () {
        myMenuItem = new MenuItem(NAME);
        
        myMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                Stage s = new Stage();
                //Scene scene = new Scene();
                s.centerOnScreen();
                
                s.show();
            }
        });
    }

    @Override
    public MenuItem getMenuItem () {
        return myMenuItem;
    }
}
