package controller;

import view.element.*;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class ViewViewController extends InteractionController {

    public ViewViewController(List<Viewable> elements) {
        super(elements);
    }

    @Override
    public void setUpInteractions() {
        setBackgroundColorChanger();
        setLineColorChanger();
        setClickableCommandHistory();
        setClickableFunctionStorage();
        setTurtleImageChanger();
        
    }

    private void setClickableFunctionStorage() {
        if (getElementByClass("StoredFunctionWindow") == null || getElementByClass("TextEntryBox") == null) {
            return;
        }
        StoredFunctionWindow funcWindow = (StoredFunctionWindow)getElementByClass("StoredFunctionWindow");
        TextEntryBox textBox = (TextEntryBox)getElementByClass("TextEntryBox");
        funcWindow.setClickEvent(event -> {
            String selectedFunction = funcWindow.getSelectedElement().split("\n")[0];
            textBox.setText(selectedFunction);
        });
    }

    private void setClickableCommandHistory() {
        if (getElementByClass("CommandHistoryWindow") == null || getElementByClass("TextEntryBox") == null) {
            return;
        }
        CommandHistoryWindow chWindow = (CommandHistoryWindow)getElementByClass("CommandHistoryWindow");
        TextEntryBox textBox = (TextEntryBox)getElementByClass("TextEntryBox");
        chWindow.setClickEvent(event -> {
            String selectedCommand= chWindow.getSelectedElement();
            textBox.setText(selectedCommand);
        });
    }
    
    private void setTurtleImageChanger(){
    	if (getElementByClass("SettingsToolBar") == null || getElementByClass("TurtleView") == null) {
            return;
        }
    	SettingsToolBar toolBar = (SettingsToolBar)getElementByClass("SettingsToolBar");
        TurtleView turtleView = (TurtleView)getElementByClass("TurtleView");
        toolBar.setAltTurtleImageHandler(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				FileChooser prompt = new FileChooser();
				prompt.setTitle("Upload Alternate Turtle Image (jpeg, png, or gif only");
				File image = prompt.showOpenDialog(null);
				if(image != null){
					try {
						String temp = image.toURI().toURL().toString();
						//System.out.println(temp);
						turtleView.setTurtleImage(temp);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
        });
    }
    

    private void setLineColorChanger(){
    	if (getElementByClass("SettingsToolBar") == null || getElementByClass("TurtleView") == null) {
            return;
        }
    	SettingsToolBar toolBar = (SettingsToolBar)getElementByClass("SettingsToolBar");
        TurtleView turtleView = (TurtleView)getElementByClass("TurtleView");
        toolBar.setLineColorPickerHandler(event -> {
            turtleView.setLineColor(toolBar.getSelectedLineColor());
        });
    	
    }

    private void setBackgroundColorChanger() {
        if (getElementByClass("SettingsToolBar") == null || getElementByClass("TurtleView") == null) {
            return;
        }
        SettingsToolBar toolBar = (SettingsToolBar)getElementByClass("SettingsToolBar");
        TurtleView turtleView = (TurtleView)getElementByClass("TurtleView");
        toolBar.setBackgroundColorPickerHandler(event -> {
            turtleView.setBackgroundColor(toolBar.getSelectedBackgroundColor());
        });
    }
    
   
}
