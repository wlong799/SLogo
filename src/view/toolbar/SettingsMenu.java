package view.toolbar;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import view.Viewable;

public class SettingsMenu implements Viewable{
    private MenuBar myMenuBar;
    private double myWidth, myHeight;


    public SettingsMenu(double width, double height) {
        myWidth = width;
        myHeight = height;
        myMenuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        myMenuBar.getMenus().addAll(menuFile, menuEdit);
    }

    @Override
    public Node getContent() {
        return myMenuBar;
    }
}
