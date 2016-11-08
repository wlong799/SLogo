package view.toolbar;

import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import view.GUIElement;

import java.util.ResourceBundle;

/**
 * SettingsMenuBar holds the menus for the application.
 *
 * @author Will Long
 */
public class SettingsMenuBar extends GUIElement {
    private ResourceBundle myUIElements;
    private String myUIElementsPath = "resources/myUIElements";
    private MenuBar myMenuBar;

    public SettingsMenuBar() {
        myUIElements = ResourceBundle.getBundle(myUIElementsPath);
        myMenuBar = new MenuBar();
    }

    @Override
    public Node getContent() {
        return myMenuBar;
    }

    public void addMenu(BaseMenu element) {
        myMenuBar.getMenus().add(element.getMenu());
    }

}
