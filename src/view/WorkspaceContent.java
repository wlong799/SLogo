package view;

import javafx.scene.Parent;
import view.panel.TabElement;
import view.panel.TabbedHelperPanel;
import view.textbox.TextEntryBox;
import view.toolbar.*;
import view.turtle.TurtleContainer;
import view.turtle.TurtleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * WorkspaceContent just provides a quick setup for the application. Non-resizable, and provides a
 * TurtleContainer, with a TextEntryBox beneath.
 */
public class WorkspaceContent implements ContentManager {
    private static final double BORDER_RATIO = 0.03;

    private ContentGrid myContentGrid;
    private ElementManager myElements;

    private double myWidth;
    private double myHeight;

    private SettingsMenuBar mySettingsMenuBar;
    private TurtleContainer myTurtleContainer;
    private TextEntryBox myTextEntryBox;
    private TabbedHelperPanel myHelperPanel;

    public WorkspaceContent(double width, double height) {
        myWidth = width;
        myHeight = height;
        double borderSize = Math.min(myHeight, myWidth) * BORDER_RATIO;
        myContentGrid = new ContentGrid(width, height, borderSize);
        myElements = new ElementManager();

        initializeSettingsMenu();
        initializeTurtleView();
        initializeHelperPanel();
        initializeTextEntryBox();
    }

    @Override
    public Parent getContentLayout() {
        return (Parent) myContentGrid.getContent();
    }

    @Override
    public ElementManager getElements() {
        return myElements;
    }

    public double getWidth() {
        return myWidth;
    }

    public double getHeight() {
        return myHeight;
    }

    private void initializeSettingsMenu() {
        mySettingsMenuBar = new SettingsMenuBar();
        myContentGrid.addMenu(mySettingsMenuBar);
        myElements.addElement(mySettingsMenuBar);
    }

    private void initializeTurtleView() {
        double width = myContentGrid.getTurtleViewWidth();
        double height = myContentGrid.getTurtleViewHeight();
        myTurtleContainer = new TurtleContainer(width, height);
        TurtleManager turtleManager = myTurtleContainer.getTurtleManager();
        myContentGrid.addTurtleView(myTurtleContainer);
        myElements.addElement(myTurtleContainer);
        myElements.addElement(turtleManager);
    }

    private void initializeHelperPanel() {
        double width = myContentGrid.getHelperPanelWidth();
        double height = myContentGrid.getHelperPanelHeight();
        myHelperPanel = new TabbedHelperPanel(width, height);
        myElements.addElement(myHelperPanel);
        myContentGrid.addHelperPanel(myHelperPanel);
    }

    private void initializeTextEntryBox() {
        double width = myContentGrid.getTextBoxWidth();
        double height = myContentGrid.getTextBoxHeight();
        myTextEntryBox = new TextEntryBox(width, height);
        myContentGrid.addTextBox(myTextEntryBox);
        myElements.addElement(myTextEntryBox);
    }

    public void addTab(String tabClass) {
        double tabWidth = myHelperPanel.getTabWidth();
        double tabHeight = myHelperPanel.getTabHeight();
        TabElement tab;
        try {
            Object obj = Class.forName(tabClass).getConstructor(double.class, double.class).newInstance(tabWidth, tabHeight);
            if (obj instanceof TabElement) {
                tab = (TabElement) obj;
            } else {
                throw new ClassCastException();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Tab class not found: " + tabClass);
            return;
        } catch (NoSuchMethodException e) {
            System.err.println("Constructor not found for class: " + tabClass);
            return;
        } catch (ClassCastException e) {
            System.err.println("Class does not extend TabElement: " + tabClass);
            return;
        } catch (Exception e) {
            System.err.println("Error when instantiating object: " + tabClass);
            return;
        }
        myHelperPanel.placeElementInNewTab(tab);
        myElements.addElement(tab);
    }

    public void addMenuElement(String menuName, String[] subMenuElementClasses) {
        BaseMenu baseMenu = new BaseMenu(menuName);
        mySettingsMenuBar.addMenu(baseMenu);
        myElements.addElement(baseMenu);
        for (String menuElementClass : subMenuElementClasses) {
            MenuElement menuElement;
            try {
                Object obj = Class.forName(menuElementClass).getConstructor().newInstance();
                if (obj instanceof MenuElement) {
                    menuElement = (MenuElement) obj;
                } else {
                    throw new ClassCastException();
                }
            } catch (ClassNotFoundException e) {
                System.err.println("Menu class not found: " + menuElementClass);
                continue;
            } catch (NoSuchMethodException e) {
                System.err.println("Constructor not found for class: " + menuElementClass);
                continue;
            } catch (ClassCastException e) {
                System.err.println("Class does not extend MenuElement: " + menuElementClass);
                continue;
            } catch (Exception e) {
                System.err.println("Error when instantiating object: " + menuElementClass);
                continue;
            }
            baseMenu.addMenuElement(menuElement);
            myElements.addElement(menuElement);
        }
    }
}
