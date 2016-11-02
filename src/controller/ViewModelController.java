package controller;

import java.util.ArrayList;
import java.util.List;
import dataStorage.*;
import javafx.collections.ListChangeListener;
import model.SLogoModel;
import view.Commander;
import view.ElementManager;
import view.panel.CommandHistoryWindow;
import view.panel.StoredFunctionWindow;
import view.panel.StoredVariableWindow;
import view.toolbar.SettingsMenuBar;
import view.turtle.TurtleContainer;
import view.turtle.TurtleManager;


public class ViewModelController extends InteractionController {
    private static final String[] COMMANDER_ELEMENTS = new String[]
            {
                    "TextEntryBox",
                    "TurtleManager"
            };

    private SLogoModel myModel;

    public ViewModelController (ElementManager viewElements, SLogoModel model) {
        super(viewElements);
        myModel = model;
    }

    @Override
    public void setUpInteractions() {
        linkCommanders();
        linkTurtleWithView();
        linkCommandHistory();
        linkFunctionStorage();
        linkVariableStorage();
        // setLanguageChanger();
    }

    private void linkCommanders() {
        for (String commandClassName : COMMANDER_ELEMENTS) {
            Commander commander = myViewElements.getCommanderElement(commandClassName);
            if (commander != null) {
                commander.setCommandTrigger(event -> {
                    String text = commander.getCommandText(myModel.getLanguage());
                    myModel.parse(text, commander.storeHistory());
                });
            }
        }
    }

    private void linkVariableStorage() {
        if (myViewElements.getGUIElement("StoredVariableWindow") == null ||
            myModel.getData() == null) {
            return;
        }

        StoredVariableWindow varWindow =
                (StoredVariableWindow) myViewElements.getGUIElement("StoredVariableWindow");
        // VariableStorage varStorage = myModel.getData().getVariableList();
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
        // CommandStorage funcStorage =
        // DataStorageManager.get().getCommandVariableStorage();
        funcWindow.setObservedList(myModel.getData().getCommandList());
    }

    public void setModel (SLogoModel model) {
        myModel = model;
    }

    private void linkTurtleWithView () {
        TurtleStorage turtleStorage = myModel.getTurtles();
        if (turtleStorage == null || myViewElements.getGUIElement("TurtleContainer") == null) {
            return;
        }
        TurtleContainer turtleContainer =
                (TurtleContainer) myViewElements.getGUIElement("TurtleContainer");
        turtleStorage.addObserver(turtleContainer);
        if (myViewElements.getGUIElement("TurtleManager") == null) {
            return;
        }
        TurtleManager turtleManager = (TurtleManager) myViewElements.getGUIElement("TurtleManager");
        turtleStorage.getActiveTurtleIDs().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged (Change<? extends Integer> c) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(c.getList());
                turtleManager.setActiveTurtleNums(newList);
            }
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