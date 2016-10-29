package controller;

import java.util.List;
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

    public ViewModelController (ElementManager viewElements, SLogoModel model) {
        super(viewElements);
        myModel = model;
    }

    @Override
    public void setUpInteractions () {
        linkTextBoxToParser();
        linkTurtleWithView();
        linkCommandHistory();
        linkFunctionStorage();
        linkVariableStorage();
        // setLanguageChanger();
    }

    private void linkVariableStorage () {
        if (myViewElements.getGUIElement("StoredVariableWindow") == null ||
            myModel.getData() == null) {
            return;
        }

        StoredVariableWindow varWindow =
                (StoredVariableWindow) myViewElements.getGUIElement("StoredVariableWindow");
        // ValueVariableStorage varStorage = myModel.getData().getVariableList();
        varWindow.setObservedList(myModel.getData().getVariableList());
        varWindow.setClickEvent(event -> varWindow.editSelectedVariable());
        varWindow.setEditedEvent(event -> {
            String[] newVals = event.getNewValue().split("\\s+");
            String name = newVals[0];
            double val = Double.parseDouble(newVals[1]);
            myModel.getData().setVariable(name, val);
        });
    }

    private void linkFunctionStorage () {
        if (myViewElements.getGUIElement("StoredFunctionWindow") == null ||
            myModel.getData() == null) {
            return;
        }

        StoredFunctionWindow funcWindow =
                (StoredFunctionWindow) myViewElements.getGUIElement("StoredFunctionWindow");
        // CommandVariableStorage funcStorage =
        // DataStorageManager.get().getCommandVariableStorage();
        funcWindow.setObservedList(myModel.getData().getCommandList());
    }

    public void setModel (SLogoModel model) {
        myModel = model;
    }

    private void linkTurtleWithView () {
        System.out.println("LINK TURTLE");
        TurtleStorage turtles = myModel.getTurtles();
        for (Turtle t : turtles.getActiveTurtles()) {
            System.out.println(t.getPosition());
        }
        if (turtles == null || myViewElements.getGUIElement("TurtleContainer") == null) {
            return;
        }
        
        TurtleContainer turtleContainer =
                (TurtleContainer) myViewElements.getGUIElement("TurtleContainer");
        System.out.println(turtleContainer.getTurtleManager().getActiveTurtles());
        turtles.addObserver(turtleContainer);
        // turtles.setVisibility(true);
    }

    private void linkTextBoxToParser () {
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

    private void setLanguageChanger () {
        if (myViewElements.getGUIElement("SettingsMenuBar") == null) {
            System.out.println("fail");
            return;
        }

        SettingsMenuBar toolBar = (SettingsMenuBar) myViewElements.getGUIElement("SettingsMenuBar");
        toolBar.setLanguageChooserHandler(event -> {
            myModel.setLanguage(toolBar.getLanguageSelection());
            System.out.println("success");
        });
        System.out.println("success");
    }

    private void linkCommandHistory () {
        if (myModel.getData() == null ||
            myViewElements.getGUIElement("CommandHistoryWindow") == null) {
            return;
        }

        CommandHistoryWindow chWindow =
                (CommandHistoryWindow) myViewElements.getGUIElement("CommandHistoryWindow");
        chWindow.setObservedList(myModel.getData().getHistoryList());
    }

}
