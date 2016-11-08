package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.SLogoView;

/**
 * Basic JavaFX boilerplate code for launching the SLogo application.
 *
 * @author Will Long
 */
public class AppLauncher extends Application {
    private static final String APP_TITLE = "SLogo";
    private static final double APP_WIDTH = 1000;
    private static final double APP_HEIGHT = 750;

    public void start(Stage stage) {
        SLogoController slogoController = new SLogoController(APP_WIDTH, APP_HEIGHT);
        SLogoView slogoView = slogoController.getSLogoView();
        stage.setTitle(APP_TITLE);
        stage.setScene(slogoView.getScene());
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
