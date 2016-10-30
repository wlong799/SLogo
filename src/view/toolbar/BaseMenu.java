package view.toolbar;

import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;

public class BaseMenu {
    private String myMenuName;
    private Menu myMenu;

    public BaseMenu(String name) {
        myMenuName = name;
        myMenu = new Menu(myMenuName);
    }

    public void addMenuElement(MenuElement menuElement) {
        myMenu.getItems().add(menuElement.getMenuItem());
    }

    public Menu getMenu() {
        return myMenu;
    }
}
