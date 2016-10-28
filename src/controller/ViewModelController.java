package controller;

import dataStorage.*;
import model.SLogoModel;
import view.ElementManager;
import view.panel.CommandHistoryWindow;
import view.panel.StoredFunctionWindow;
import view.panel.StoredVariableWindow;
import view.textbox.TextEntryBox;
import view.toolbar.SettingsMenuBar;
import view.turtle.TurtleContainer;


public class ViewModelController extends InteractionController {
    private SLogoModel myModel;

    public ViewModelController(ElementManager viewElements, SLogoModel model) {
        super(viewElements);
        myModel = model;
    }

    @Override
    public void setUpInteractions() {
        linkTextBoxToParser();
        linkTurtleWithView();
        linkCommandHistory();
        linkFunctionStorage();
        linkVariableStorage();
        //setLanguageChanger();
    }

    private void linkVariableStorage() {
        if (myViewElements.getGUIElement("StoredVariableWindow") == null ||
                DataStorageManager.get().getValueVariableStorage() == null) {
            return;
        }

        StoredVariableWindow varWindow = (StoredVariableWindow) getElementByClass("StoredVariableWindow");
        //ValueVariableStorage varStorage = myModel.getData().getVariableList();
        varWindow.setStoredVariableList(myModel.getData().getVariableList());
        varWindow.setClickEvent(event -> varWindow.editSelectedVariable());
        varWindow.setEditedEvent(event -> {
            String[] newVals = event.getNewValue().split("\\s+");
            String name = newVals[0];
            double val = Double.parseDouble(newVals[1]);
            myModel.getData().setVariable(name, val);
        });
    }

    private void linkFunctionStorage() {
        if (myViewElements.getGUIElement("StoredFunctionWindow") == null ||
                DataStorageManager.get().getCommandVariableStorage() == null) {
            return;
        }

        StoredFunctionWindow funcWindow = (StoredFunctionWindow) getElementByClass("StoredFunctionWindow");
        //CommandVariableStorage funcStorage = DataStorageManager.get().getCommandVariableStorage();
        funcWindow.setStoredFunctionList(myModel.getData().getCommandList());
    }

    public void setModel(SLogoModel model) {
        myModel = model;
    }

    private void linkTurtleWithView() {
        List<Turtle> turtle = myModel.getActiveTurtles();
        if (turtle == null || getElementByClass("TurtleView") == null) {
            return;
        }
        TurtleContainer turtleContainer = (TurtleContainer) myViewElements.getGUIElement("TurtleContainer");

        turtle.addObserver(turtleContainer);
        turtle.setVisibility(true);
    }


    private void linkTextBoxToParser() {
        if (myModel.noParser() || myViewElements.getGUIElement("TextEntryBox") == null) {
            return;
        }
        TextEntryBox textEntryBox = (TextEntryBox) myViewElements.getGUIElement("TextEntryBox");
        textEntryBox.setSubmitHandler(event -> {
            String entryText = textEntryBox.getEnteredText().trim();
            if (entryText == null || entryText.length() == 0) {
                return;
            }
            myModel.parse(entryText);
        });
    }

    private void setLanguageChanger(){
    	if (myViewElements.getGUIElement("SettingsMenuBar") == null){
    		System.out.println("fail");
    		return;
    	}

    	SettingsMenuBar toolBar = (SettingsMenuBar) myViewElements.getGUIElement("SettingsMenuBar");
    	toolBar.setLanguageChooserHandler(event -> {myModel.setLanguage(toolBar.getLanguageSelection());
    	System.out.println("success");});
    	System.out.println("success");
    }

    private void linkCommandHistory() {
        if (DataStorageManager.get().getCommandHistoryStorage() == null ||
                myViewElements.getGUIElement("CommandHistoryWindow") == null) {
            return;
        }
        CommandHistoryStorage chStorage = DataStorageManager.get().getCommandHistoryStorage();
        CommandHistoryWindow chWindow = (CommandHistoryWindow) myViewElements.getGUIElement("CommandHistoryWindow");
        chWindow.setObservedList(chStorage.getCommandHistoryList());
    }

}
