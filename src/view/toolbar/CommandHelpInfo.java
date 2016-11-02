package view.toolbar;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
                String url = getClass().getResource("/resources/SlogoHelp.html").toExternalForm();
         	   	WebView view = new WebView();
         	   	view.getEngine().load(url);
         	   	Scene scene = new Scene(view);
                s.centerOnScreen();
                s.setScene(scene);
                s.sizeToScene();
                s.show();
            }
        });
            
  
    }

    @Override
    public MenuItem getMenuItem () {
        return myMenuItem;
    }
    
 
}

