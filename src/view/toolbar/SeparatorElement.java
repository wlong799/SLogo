package view.toolbar;

import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 * Simple class for providing a separator within a menu.
 */
public class SeparatorElement extends MenuElement {

    @Override
    public MenuItem getMenuItem() {
        return new SeparatorMenuItem();
    }
}
