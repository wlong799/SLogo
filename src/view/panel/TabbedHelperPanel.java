package view.panel;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import view.GUIElement;

public class TabbedHelperPanel extends GUIElement {

    private TabPane myTabContainer;

    public TabbedHelperPanel(double width, double height) {
        super(width, height);
        myTabContainer = new TabPane();
        myTabContainer.setPrefWidth(myWidth);
        myTabContainer.setPrefHeight(myHeight);
        myTabContainer.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    public void placeElementInNewTab(TabElement newTabElement) {
        String tabName = newTabElement.getTabName();
        Node tabContent = newTabElement.getContent();
        Tab newTab = new Tab(tabName, tabContent);
        myTabContainer.getTabs().add(newTab);
    }

    public double getTabWidth() {
        return myWidth;
    }

    public double getTabHeight() {
        return myHeight;
    }

    @Override
    public Node getContent() {
        return myTabContainer;
    }
}
