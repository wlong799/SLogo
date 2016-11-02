package view.toolbar;

import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import view.Style;
import view.Stylizable;
import view.Stylizer;

public class PenDownToggle extends MenuElement implements Stylizer{
	
	private static final String NAME = "Pen Down Toggle";
	private MenuItem myMenuItem;
	private CheckBox myCheckBox;
	


	public PenDownToggle(){
		myCheckBox = new CheckBox();
		myCheckBox.setSelected(true);
		myMenuItem = new MenuItem(NAME, myCheckBox);
		
	}
	
	@Override
	public MenuItem getMenuItem() {
		return myMenuItem;
	}

	@Override
	public void setStylizableTarget(Stylizable stylizableTarget) {
		myCheckBox.setOnAction(i ->{
			boolean boxStatus = myCheckBox.isSelected();
			Style style = new Style(boxStatus);
			stylizableTarget.setStyle(style);
		});
		}
		
		
	}


