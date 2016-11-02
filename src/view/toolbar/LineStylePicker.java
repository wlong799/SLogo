package view.toolbar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import view.Style;
import view.Stylizable;
import view.Stylizer;

public class LineStylePicker extends MenuElement implements Stylizer{
   
	private static final String NAME = "Line Style";
    private static final String[] LINE_OPTIONS = {"Solid", "Dashed", "Dotted"};
    private Menu myMenu;
    private ToggleGroup myLineToggle;
    
    public LineStylePicker(){
    	myMenu = new Menu(NAME);
    	myLineToggle = new ToggleGroup();
    	
    	for(String i : LINE_OPTIONS){
    		RadioMenuItem temp = new RadioMenuItem(i);
    		temp.setUserData(i);
    		temp.setToggleGroup(myLineToggle);
    		myMenu.getItems().add(temp);
    	}
    	
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenu;
    }

    @Override
    public void setStylizableTarget(Stylizable stylizableTarget) {
    	myLineToggle.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (myLineToggle.getSelectedToggle() != null) {
                
                Style style = new Style((String)myLineToggle.getSelectedToggle().getUserData());
                stylizableTarget.setStyle(style);
            }
        });

    }
}
