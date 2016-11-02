package view.toolbar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AboutInfo extends MenuElement {
    private static final String NAME = "About";

    private MenuItem myMenuItem;

    public AboutInfo() {
        myMenuItem = new MenuItem(NAME);
        myMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                Stage s = new Stage();
                String url = getClass().getResource("/resources/About.html").toExternalForm();
                        WebView view = new WebView();
                        view.getEngine().load(url);
                        Scene scene = new Scene(view);
                s.centerOnScreen();
                s.setScene(scene);
                s.sizeToScene();
                s.show();
            }
        });
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
