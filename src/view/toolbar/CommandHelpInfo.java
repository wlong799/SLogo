package view.toolbar;

import javafx.scene.control.MenuItem;

public class CommandHelpInfo extends MenuElement {
    private static final String NAME = "Command Help";

    private MenuItem myMenuItem;

    public CommandHelpInfo() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
