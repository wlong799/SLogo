package view.toolbar;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import view.Style;
import view.Stylizable;
import view.Stylizer;

/**
 * Menu element for editing the current color of the line.
 *
 * @author Will Long
 */
public class LineColorPicker extends MenuElement implements Stylizer {
    private static final String NAME = "Change Line Color";
    private static final Color DEFAULT_COLOR = Color.BLACK;

    private MenuItem myMenuItem;
    private ColorPicker myLineColorPicker;

    public LineColorPicker() {
        myLineColorPicker = new ColorPicker(DEFAULT_COLOR);
        myMenuItem = new MenuItem(NAME, myLineColorPicker);
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }

    @Override
    public void setStylizableTarget(Stylizable stylizableTarget) {
        myLineColorPicker.setOnAction(event -> {
            Color color = myLineColorPicker.getValue();
            Style style = new Style(color);
            stylizableTarget.setStyle(style);
        });
    }
}
