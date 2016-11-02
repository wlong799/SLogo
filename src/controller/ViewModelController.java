package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import dataStorage.*;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.SLogoModel;
import view.ElementManager;
import view.panel.TabElement;
import view.toolbar.SettingsMenuBar;
import view.turtle.TurtleContainer;
import view.turtle.TurtleManager;


public class ViewModelController extends InteractionController {
    private static final String[][] OBSERVABLE_LIST_LINKS = new String[][]
            {
                    {"StoredVariableWindow", "getVariableList"},
                    {"PaletteWindow", "getColorList"},
                    {"StoredFunctionWindow", "getCommandList"},
                    {"CommandHistoryWindow", "getHistoryList"},
            };

    private SLogoModel myModel;

    public ViewModelController(ElementManager viewElements, SLogoModel model) {
        super(viewElements);
        myModel = model;
    }

    @Override
    public void setUpInteractions() {
        linkCommanders();
        setObservableLists();
        linkTurtleWithView();
        //linkCommandHistory();
        //linkFunctionStorage();
        //linkVariableStorage();
        //linkColorStorage();
        // setLanguageChanger();
    }

    private void linkCommanders() {
        myViewElements.getCommanderElements().forEach(commander -> {
            commander.setCommandTrigger(event -> {
                String text = commander.getCommandText(myModel.getLanguage());
                myModel.parse(text, commander.storeHistory());
            });
        });
    }

    private void setObservableLists() {
        for (String[] linkedObserverAndList : OBSERVABLE_LIST_LINKS) {
            String tabElementName = linkedObserverAndList[0];
            String methodName = linkedObserverAndList[1];
            TabElement observer = myViewElements.getTabElement(tabElementName);
            if (observer == null) {
                return;
            }
            DataStorageManager data = myModel.getData();
            ObservableList<String> observableList = null;
            try {
                Object obj = data.getClass().getMethod(methodName, null).invoke(data);
                if (!(obj instanceof ObservableList)) {
                    throw new ClassCastException();
                }
                observableList = (ObservableList<String>) obj;
            } catch (IllegalAccessException e) {
                System.out.println("Do not have access to method: " + methodName);
            } catch (InvocationTargetException e) {
                System.out.println("Method invoked on incorrect target: " + data);
            } catch (NoSuchMethodException e) {
                System.out.println("Method does not exist: " + methodName);
            } catch (ClassCastException e) {
                System.out.println("Method does not return an ObservableList: " + methodName);
            }
            observer.setObservedList(observableList);
        }
    }

    /*
        private void linkVariableStorage() {
            if (myViewElements.getGUIElement("StoredVariableWindow") == null ||
                    myModel.getData() == null) {
                return;
            }

            StoredVariableWindow varWindow =
                    (StoredVariableWindow) myViewElements.getGUIElement("StoredVariableWindow");
            varWindow.setObservedList(myModel.getData().getVariableList());
            varWindow.setClickEvent(event -> varWindow.editSelectedVariable());
            varWindow.setEditedEvent(event -> {
                String[] newVals = event.getNewValue().split("\\s+");
                String name = newVals[0];
                double val = Double.parseDouble(newVals[1]);
                myModel.getData().setVariable(name, val);
            });
        }

        private void linkColorStorage() {
            if (myViewElements.getGUIElement("PaletteWindow") == null ||
                    myModel.getData() == null) {
                System.out.println("NULL BITCH");
                return;
            }
            PaletteWindow colorWindow = (PaletteWindow) myViewElements.getGUIElement("PaletteWindow");
            colorWindow.setObservedList(myModel.getData().getColorList());
        }

        private void linkFunctionStorage() {
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

        public void setModel(SLogoModel model) {
            myModel = model;
        }
    */
    private void linkTurtleWithView() {
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
            public void onChanged(Change<? extends Integer> c) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(c.getList());
                turtleManager.setActiveTurtleNums(newList);
            }
        });
    }

    private void setLanguageChanger() {
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
/*
    private void linkCommandHistory() {
        if (myModel.getData() == null ||
                myViewElements.getGUIElement("CommandHistoryWindow") == null) {
            return;
        }

        CommandHistoryWindow chWindow =
                (CommandHistoryWindow) myViewElements.getGUIElement("CommandHistoryWindow");
        chWindow.setObservedList(myModel.getData().getHistoryList());
    }
*/
}
