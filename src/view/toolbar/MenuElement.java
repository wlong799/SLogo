package view.toolbar;

import javafx.scene.control.MenuItem;

/**
 * Abstract class for all elements to be added to menu to extend. Probably should've been an interface but it's too late
 * to fix that now.
 *
 * @author Will Long
 */
public abstract class MenuElement {

    public abstract MenuItem getMenuItem();

}
