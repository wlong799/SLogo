package view.toolbar;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import view.Style;
import view.Stylizable;
import view.Stylizer;

public class BackgroundColorPicker extends MenuElement implements Stylizer{
    private static final String NAME = "Change Background";
    private static final Color DEFAULT_COLOR = Color.WHITE;

    private MenuItem myMenuItem;
    private ColorPicker myBGColorPicker;

    public BackgroundColorPicker() {
        myBGColorPicker = new ColorPicker(DEFAULT_COLOR);
        myMenuItem = new MenuItem(NAME, myBGColorPicker);
    }


    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }

    @Override
    public void setStylizableTarget(Stylizable stylizableTarget) {
        myBGColorPicker.setOnAction(event -> {
            Color color = myBGColorPicker.getValue();
            Style style = new Style(color);
            stylizableTarget.setStyle(style);
        });
    }
}
