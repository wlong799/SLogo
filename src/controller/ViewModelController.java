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
import view.toolbar.LanguageChooser;
import view.turtle.TurtleContainer;
import view.turtle.TurtleManager;

/**
 * Controller responsible for linking elements in view with elements in model. Some elements must be explicitly linked,
 * (e.g. give TabElement class and function for getting its relevant ObservableList). Others are loaded automatically if
 * they implement the correct interface (e.g. Commander).
 *
 * @author Will Long
 */
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
        linkLanguageChooser();
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
                ////System.out.println("Do not have access to method: " + methodName);
            } catch (InvocationTargetException e) {
                ////System.out.println("Method invoked on incorrect target: " + data);
            } catch (NoSuchMethodException e) {
                ////System.out.println("Method does not exist: " + methodName);
            } catch (ClassCastException e) {
                ////System.out.println("Method does not return an ObservableList: " + methodName);
            }
            observer.setObservedList(observableList);
        }
    }

    private void linkTurtleWithView() {
        TurtleStorage turtleStorage = myModel.getTurtles();
        if (turtleStorage == null || myViewElements.getGUIElement("TurtleContainer") == null) {
            return;
        }
        TurtleContainer turtleContainer =
                (TurtleContainer) myViewElements.getGUIElement("TurtleContainer");
        turtleStorage.addObserver(turtleContainer);
        myModel.getData().getNotifications().addObserver(turtleContainer);
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
        ColorStorage colorStorage = myModel.getData().getColors();
        colorStorage.addObserver(turtleContainer);
    }

    private void linkLanguageChooser() {
        if (myViewElements.getGUIElement("LanguageChooser") == null) {
            return;
        }
        LanguageChooser languageChooser = (LanguageChooser) myViewElements.getGUIElement("LanguageChooser");
        languageChooser.setEventHandler(event -> {
            String language = languageChooser.getSelectedLanguage();
            if (language != null) {
                myModel.setLanguage(language);
            }
        });
    }
}
