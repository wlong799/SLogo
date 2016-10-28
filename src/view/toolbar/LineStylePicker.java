package view.toolbar;

import javafx.scene.control.MenuItem;
import view.Stylizable;
import view.Stylizer;

public class LineStylePicker extends MenuElement implements Stylizer{
    private static final String NAME = "Change Line Style";

    @Override
    public MenuItem getMenuItem() {
        return new MenuItem(NAME);
    }

    @Override
    public void setStylizableTarget(Stylizable stylizableTarget) {

    }
}
