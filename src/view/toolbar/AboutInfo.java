package view.toolbar;

import javafx.scene.control.MenuItem;

public class AboutInfo extends MenuElement {
    private static final String NAME = "About";

    private MenuItem myMenuItem;

    public AboutInfo() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
