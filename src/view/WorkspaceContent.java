package view;

import javafx.scene.Parent;
import view.panel.TabElement;
import view.panel.TabbedHelperPanel;
import view.textbox.TextEntryBox;
import view.toolbar.SettingsMenu;
import view.turtle.TurtleView;

/**
 * WorkspaceContent just provides a quick setup for the application. Non-resizable, and provides a
 * TurtleView, with a TextEntryBox beneath.
 */
public class WorkspaceContent implements ContentManager {
    private static final double BORDER_RATIO = 0.03;

    private ContentGrid myContentGrid;
    private ViewElementManager myViewElements;

    private double myWidth;
    private double myHeight;

    private SettingsMenu mySettingsMenu;
    private TurtleView myTurtleView;
    private TextEntryBox myTextEntryBox;
    private TabbedHelperPanel myHelperPanel;

    public WorkspaceContent(double width, double height) {
        myWidth = width;
        myHeight = height;
        double borderSize = Math.min(myHeight, myWidth) * BORDER_RATIO;
        myContentGrid = new ContentGrid(width, height, borderSize);
        myViewElements = new ViewElementManager();

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
    public ViewElementManager getElements() {
        return myViewElements;
    }

    public double getWidth() {
        return myWidth;
    }

    public double getHeight() {
        return myHeight;
    }

    private void initializeSettingsMenu() {
        mySettingsMenu = new SettingsMenu();
        myContentGrid.addMenu(mySettingsMenu);
        myViewElements.addElement(mySettingsMenu);
        //SettingsToolBar settingsToolBar = new SettingsToolBar(width, height);
        //myContentGrid.addMenu(settingsToolBar);
        //myViewElements.addElement(settingsToolBar);
    }

    private void initializeTurtleView() {
        double width = myContentGrid.getTurtleViewWidth();
        double height = myContentGrid.getTurtleViewHeight();
        myTurtleView = new TurtleView(width, height);
        myContentGrid.addTurtleView(myTurtleView);
        myViewElements.addElement(myTurtleView);
    }

    private void initializeHelperPanel() {
        double width = myContentGrid.getHelperPanelWidth();
        double height = myContentGrid.getHelperPanelHeight();
        myHelperPanel = new TabbedHelperPanel(width, height);
        myViewElements.addElement(myHelperPanel);
        myContentGrid.addHelperPanel(myHelperPanel);
    }

    private void initializeTextEntryBox() {
        double width = myContentGrid.getTextBoxWidth();
        double height = myContentGrid.getTextBoxHeight();
        TextEntryBox textEntryBox = new TextEntryBox(width, height);
        myContentGrid.addTextBox(textEntryBox);
        myViewElements.addElement(textEntryBox);
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
        myViewElements.addElement(tab);
    }
}
