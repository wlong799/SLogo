package controller;

import dataStorage.*;
import model.SLogoModel;
import view.ViewElementManager;
import view.panel.CommandHistoryWindow;
import view.panel.StoredFunctionWindow;
import view.panel.StoredVariableWindow;
import view.textbox.TextEntryBox;
import view.toolbar.SettingsMenuBar;
import view.turtle.TurtleView;


public class ViewModelController extends InteractionController {
    private SLogoModel myModel;

    public ViewModelController(ViewElementManager viewElements, SLogoModel model) {
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
        setLanguageChanger();
    }

    private void linkVariableStorage() {
        if (myViewElements.getElement("StoredVariableWindow") == null ||
                DataStorageManager.get().getValueVariableStorage() == null) {
            return;
        }
        StoredVariableWindow varWindow = (StoredVariableWindow) myViewElements.getElement("StoredVariableWindow");
        ValueVariableStorage varStorage = DataStorageManager.get().getValueVariableStorage();
        varWindow.setObservedList(varStorage.getVariableList());
        varWindow.setClickEvent(event -> varWindow.editSelectedVariable());
        varWindow.setEditedEvent(event -> {
            String[] newVals = event.getNewValue().split("\\s+");
            String name = newVals[0];
            double val = Double.parseDouble(newVals[1]);
            varStorage.setVariable(name, val);
        });
    }

    private void linkFunctionStorage() {
        if (myViewElements.getElement("StoredFunctionWindow") == null ||
                DataStorageManager.get().getCommandVariableStorage() == null) {
            return;
        }
        StoredFunctionWindow funcWindow = (StoredFunctionWindow) myViewElements.getElement("StoredFunctionWindow");
        CommandVariableStorage funcStorage = DataStorageManager.get().getCommandVariableStorage();
        funcWindow.setObservedList(funcStorage.getCommandVariableList());
    }

    public void setModel(SLogoModel model) {
        myModel = model;
    }

    private void linkTurtleWithView() {
        Turtle turtle = myModel.getTurtle();
        if (turtle == null || myViewElements.getElement("TurtleView") == null) {
            return;
        }
        TurtleView turtleView = (TurtleView) myViewElements.getElement("TurtleView");

        turtle.addObserver(turtleView);
        turtle.setVisibility(true);
    }


    private void linkTextBoxToParser() {
        if (myModel.noParser() || myViewElements.getElement("TextEntryBox") == null) {
            return;
        }
        TextEntryBox textEntryBox = (TextEntryBox) myViewElements.getElement("TextEntryBox");
        textEntryBox.setSubmitHandler(event -> {
            String entryText = textEntryBox.getEnteredText().trim();
            if (entryText == null || entryText.length() == 0) {
                return;
            }
            myModel.parse(entryText);
        });
    }

    private void setLanguageChanger() {
        if (myViewElements.getElement("SettingsMenuBar") == null) {
            System.out.println("fail");
            return;
        }

        SettingsMenuBar toolBar = (SettingsMenuBar) myViewElements.getElement("SettingsMenuBar");
        toolBar.setLanguageChooserHandler(event -> {
            myModel.setLanguage(toolBar.getLanguageSelection());
            System.out.println("success");
        });
        System.out.println("success");
    }

    private void linkCommandHistory() {
        if (DataStorageManager.get().getCommandHistoryStorage() == null ||
                myViewElements.getElement("CommandHistoryWindow") == null) {
            return;
        }
        CommandHistoryStorage chStorage = DataStorageManager.get().getCommandHistoryStorage();
        CommandHistoryWindow chWindow = (CommandHistoryWindow) myViewElements.getElement("CommandHistoryWindow");
        chWindow.setObservedList(chStorage.getCommandHistoryList());
    }

}
