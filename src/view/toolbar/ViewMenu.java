package view.toolbar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class ViewMenu extends AbstractMenu{
    private static final String NAME = "View";

    public ViewMenu() {
        myMenu = new Menu(NAME);

        MenuItem bgColor = new MenuItem("Change Background");
        MenuItem lineColor = new MenuItem("Change Line Color");
        MenuItem lineSize = new MenuItem("Change Line Size");
        MenuItem lineStyle = new MenuItem("Change Line Style");
        MenuItem turtleImage = new MenuItem("Change Turtle Image");

        myMenu.getItems().add(bgColor);
        addSeparator();
        myMenu.getItems().addAll(lineColor, lineSize, lineStyle);
        addSeparator();
        myMenu.getItems().addAll(turtleImage);
    }
}
