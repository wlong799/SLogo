package view.toolbar;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import view.Style;
import view.Stylizable;
import view.Stylizer;

public class CustomTurtleImageInput extends MenuElement implements Stylizer{
	
	
	private static final String NAME = "Upload a Custom Turtle Image";
	private MenuItem myMenuItem;
	
	public CustomTurtleImageInput(){
		myMenuItem = new MenuItem(NAME);	
	}

	@Override
    public MenuItem getMenuItem(){
        return myMenuItem;
    }

    @Override
    public void setStylizableTarget(Stylizable stylizableTarget) {
    	myMenuItem.setOnAction( i -> {
			FileChooser prompt = new FileChooser();
			prompt.setTitle("Upload Alternate Turtle Image (jpeg, png, or gif only");
			File image = prompt.showOpenDialog(null);
			if(image != null){
				try {
					String temp = image.toURI().toURL().toString();
					Image upImage = new Image(temp);
					Style style = new Style(upImage);
					stylizableTarget.setStyle(style);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		});
    
        
    }
}
