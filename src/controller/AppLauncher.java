package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.SLogoView;

/**
 * Basic JavaFX boilerplate code for launching the application
 */
public class AppLauncher extends Application {
    private static final String APP_TITLE = "SLogo";

    public void start(Stage stage) {
        SLogoController slogoController = new SLogoController();
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