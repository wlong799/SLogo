package view.toolbar;

import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;

/**
 * Generic menu superclass
 */
public abstract class AbstractMenu{
    protected Menu myMenu;

    public void addMenuElement(MenuElement menuElement) {
        myMenu.getItems().add(menuElement.getMenuItem());
    }

    public void addSeparator() {
        myMenu.getItems().add(new SeparatorMenuItem());
    }

    public Menu getMenu() {
        return myMenu;
    }
}
