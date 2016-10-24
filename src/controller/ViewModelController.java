package controller;

import dataStorage.*;
import model.CommandParser;
import model.SLogoModel;
import view.element.*;

import java.util.List;


public class ViewModelController extends InteractionController {
    private SLogoModel myModel;

    protected ViewModelController(List<ViewElement> elements) {
        super(elements);
    }

    @Override
    public void setUpInteractions() {
        linkTextBoxToParser();
        linkTurtleWithView();
        linkCommandHistory();
        linkFunctionStorage();
        linkVariableStorage();
    }

    private void linkVariableStorage() {
        if (getElementByClass("StoredVariableWindow") == null ||
                DataStorageManager.get().getValueVariableStorage() == null) {
            return;
        }
        StoredVariableWindow varWindow = (StoredVariableWindow) getElementByClass("StoredVariableWindow");
        ValueVariableStorage varStorage = DataStorageManager.get().getValueVariableStorage();
        varWindow.setStoredVariableList(varStorage.getVariableList());
    }

    private void linkFunctionStorage() {
        if (getElementByClass("StoredFunctionWindow") == null ||
                DataStorageManager.get().getCommandVariableStorage() == null) {
            return;
        }
        StoredFunctionWindow funcWindow = (StoredFunctionWindow) getElementByClass("StoredFunctionWindow");
        CommandVariableStorage funcStorage = DataStorageManager.get().getCommandVariableStorage();
        funcWindow.setStoredFunctionList(funcStorage.getCommandVariableList());
    }

    public void setModel(SLogoModel model) {
        myModel = model;
    }

    private void linkTurtleWithView() {
        Turtle turtle = myModel.getTurtle();
        if (turtle == null || getElementByClass("TurtleView") == null) {
            return;
        }
        TurtleView turtleView = (TurtleView) getElementByClass("TurtleView");

        turtle.addObserver(turtleView);
        turtle.setVisibility(true);
    }


    private void linkTextBoxToParser() {
        if (myModel.noParser() || getElementByClass("TextEntryBox") == null) {
            return;
        }
        TextEntryBox textEntryBox = (TextEntryBox) getElementByClass("TextEntryBox");
        textEntryBox.setSubmitHandler(event -> {
            String entryText = textEntryBox.getEnteredText().trim();
            if (entryText == null || entryText.length() == 0) {
                return;
            }
            myModel.parse(entryText);
        });
    }

    private void linkCommandHistory() {
        if (DataStorageManager.get().getCommandHistoryStorage() == null ||
                getElementByClass("CommandHistoryWindow") == null) {
            return;
        }
        CommandHistoryStorage chStorage = DataStorageManager.get().getCommandHistoryStorage();
        CommandHistoryWindow chWindow = (CommandHistoryWindow) getElementByClass("CommandHistoryWindow");
        chWindow.setCommandHistory(chStorage.getCommandHistoryList());
    }

}
