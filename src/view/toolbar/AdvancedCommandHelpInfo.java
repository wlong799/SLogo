package view.toolbar;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.scene.control.MenuItem;

public class AdvancedCommandHelpInfo extends MenuElement{
	
	   private static final String NAME = "Extended Command Help";
	   private MenuItem myMenuItem;
	   
	   public AdvancedCommandHelpInfo () {
	    	
	        myMenuItem = new MenuItem(NAME);
	        myMenuItem.setOnAction(i->{
	            try {
	                Desktop.getDesktop().browse(new URI("http://www.cs.duke.edu/courses/compsci308/fall16/assign/03_slogo/commands2_J2W.php"));
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


