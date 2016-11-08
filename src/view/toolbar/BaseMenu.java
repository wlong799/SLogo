package view.toolbar;

import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;

/**
 * Top level menu to be placed directly into the menu bar. Has a name, and is able to add sub-elements.
 *
 * @author Will Long
 */
public class BaseMenu {
    private String myMenuName;
    private Menu myMenu;

    /**
     * Creates a new menu with the specified name.
     *
     * @param name is name of the menu.
     */
    public BaseMenu(String name) {
        myMenuName = name;
        myMenu = new Menu(myMenuName);
    }

    /**
     * Adds the specified MenuElement to this menu.
     *
     * @param menuElement is MenuElement to add.
     */
    public void addMenuElement(MenuElement menuElement) {
        myMenu.getItems().add(menuElement.getMenuItem());
    }

    public Menu getMenu() {
        return myMenu;
    }
}
