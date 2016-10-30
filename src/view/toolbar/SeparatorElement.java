package view.toolbar;

import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class SeparatorElement extends MenuElement {

    @Override
    public MenuItem getMenuItem() {
        return new SeparatorMenuItem();
    }
}
