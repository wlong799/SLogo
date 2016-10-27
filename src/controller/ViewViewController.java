package controller;

import view.ViewElementManager;
import view.element.*;

import java.io.File;
import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class ViewViewController extends InteractionController {

    public ViewViewController(ViewElementManager viewElements) {
        super(viewElements);
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
        if (myViewElements.getElement("StoredFunctionWindow") == null || myViewElements.getElement("TextEntryBox") == null) {
            return;
        }
        StoredFunctionWindow funcWindow = (StoredFunctionWindow) myViewElements.getElement("StoredFunctionWindow");
        TextEntryBox textBox = (TextEntryBox) myViewElements.getElement("TextEntryBox");
        funcWindow.setClickEvent(event -> {
            String selectedFunction = funcWindow.getSelectedElement().split("\n")[0];
            textBox.setText(selectedFunction);
        });
    }

    private void setClickableCommandHistory() {
        if (myViewElements.getElement("CommandHistoryWindow") == null || myViewElements.getElement("TextEntryBox") == null) {
            return;
        }
        CommandHistoryWindow chWindow = (CommandHistoryWindow) myViewElements.getElement("CommandHistoryWindow");
        TextEntryBox textBox = (TextEntryBox) myViewElements.getElement("TextEntryBox");
        chWindow.setClickEvent(event -> {
            String selectedCommand= chWindow.getSelectedElement();
            textBox.setText(selectedCommand);
        });
    }
    
    private void setTurtleImageChanger(){
    	if (myViewElements.getElement("SettingsToolBar") == null || myViewElements.getElement("TurtleView") == null) {
            return;
        }
    	SettingsToolBar toolBar = (SettingsToolBar) myViewElements.getElement("SettingsToolBar");
        TurtleView turtleView = (TurtleView) myViewElements.getElement("TurtleView");
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
    	if (myViewElements.getElement("SettingsToolBar") == null || myViewElements.getElement("TurtleView") == null) {
            return;
        }
    	SettingsToolBar toolBar = (SettingsToolBar) myViewElements.getElement("SettingsToolBar");
        TurtleView turtleView = (TurtleView) myViewElements.getElement("TurtleView");
        toolBar.setLineColorPickerHandler(event -> {
            turtleView.setLineColor(toolBar.getSelectedLineColor());
        });
    	
    }

    private void setBackgroundColorChanger() {
        if (myViewElements.getElement("SettingsToolBar") == null || myViewElements.getElement("TurtleView") == null) {
            return;
        }
        SettingsToolBar toolBar = (SettingsToolBar) myViewElements.getElement("SettingsToolBar");
        TurtleView turtleView = (TurtleView) myViewElements.getElement("TurtleView");
        toolBar.setBackgroundColorPickerHandler(event -> {
            turtleView.setBackgroundColor(toolBar.getSelectedBackgroundColor());
        });
    }
    
   
}
