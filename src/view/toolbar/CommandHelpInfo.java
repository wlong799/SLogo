package view.toolbar;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class CommandHelpInfo extends MenuElement {
   
	private static final String NAME = "Basic Command Help";
    private MenuItem myMenuItem;

    public CommandHelpInfo () {
    	
        myMenuItem = new MenuItem(NAME);
        myMenuItem.setOnAction(i->{
            try {
                Desktop.getDesktop().browse(new URI("http://www.cs.duke.edu/courses/compsci308/fall16/assign/03_slogo/commands.php"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
            
  
    }

    @Override
    public MenuItem getMenuItem () {
        return myMenuItem;
    }
}
