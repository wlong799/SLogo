package view.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;


public class PaletteWindow extends TabElement {

    public PaletteWindow (double width, double height) {
        super(width, height);
        this.myListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

            @Override
            public ListCell<String> call (ListView<String> param) {
                return new ColorCell();
            }

        });
    }

    @Override
    public String getTabName () {
        return "Palette";
    }

    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        return;
    }

    @Override
    public String getCommandText(String language) {
        return null;
    }

    @Override
    public boolean storeHistory() {
        return false;
    }

    private class ColorCell extends ListCell<String> {
        @Override
        public void updateItem (String item, boolean empty) {
            System.out.println("add color");
            System.out.println(item);

            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (empty || item == null) {
                setGraphic(null);
                setText(null);
            }
            else {
                String[] indexAndColor = item.split(" ");
                rect.setFill(Color.web(indexAndColor[1]));
                setGraphic(rect);
                this.setText(indexAndColor[0]);
            }
        }

    }
}
