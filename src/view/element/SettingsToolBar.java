package view.element;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import view.Viewable;


public class SettingsToolBar implements Viewable {
    private double myWidth, myHeight;

    private ResourceBundle myUIElements;
    private String myUIElementsPath = "resources/myUIElements";
    private ToolBar myToolBar;
    private ColorPicker myBackgroundColorPicker;
    private ColorPicker myLineColorPicker;
    private Button altTurtleImage;
    private ComboBox<String> languageChooser;
    private Button helpButton;
    private int number_of_languages = 8;

    public SettingsToolBar (double width, double height) {
        myWidth = width;
        myHeight = height;
        myUIElements = ResourceBundle.getBundle(myUIElementsPath);
        myToolBar = new ToolBar();
        myToolBar.setStyle("-fx-background-color: #00FF00");
        myToolBar.setPrefWidth(myWidth);
        myToolBar.setPrefHeight(myHeight);

        myToolBar.getItems().add(new Label(myUIElements.getString("lineColorChangerLabel") + "  "));
        myLineColorPicker = new ColorPicker(Color.BLACK);
        myToolBar.getItems().add(myLineColorPicker);

        myToolBar.getItems()
                .add(new Label("  " + myUIElements.getString("backColorChangerLabel") + "  "));
        myBackgroundColorPicker = new ColorPicker();
        myToolBar.getItems().add(myBackgroundColorPicker);

        myToolBar.getItems()
                .add(new Label("  " + myUIElements.getString("languageChangerLabel") + "  "));

        languageChooser = createComboBox("languageChooser", number_of_languages);
        languageChooser.setValue("English");
        myToolBar.getItems().add(languageChooser);

        altTurtleImage = createButton("altTurtleImage");
        myToolBar.getItems().add(altTurtleImage);

        helpButton = createButton("helpButton");
        setHelpButtonHandler();
        myToolBar.getItems().add(helpButton);

    }

    private ComboBox<String> createComboBox (String description, int numberOfOptions) {

        ArrayList<String> options = new ArrayList<String>();

        for (int i = 1; i < numberOfOptions + 1; i++) {
            String temp = myUIElements.getString(description + Integer.toString(i));
            if (!temp.equals(null)) {
                options.add(temp);
            }
        }

        ComboBox<String> box = new ComboBox<String>();
        box.getItems().addAll(options.toArray(new String[options.size()]));
        return box;
    }

    private Button createButton (String description) {

        Button ret = new Button();
        String retText = myUIElements.getString(description);
        ret.setText(retText);

        DropShadow effect = new DropShadow();
        ret.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent e) {
                ret.setEffect(effect);
            }
        });

        ret.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent e) {
                ret.setEffect(null);
            }
        });

        return ret;

    }

    public void setLineColorPickerHandler (EventHandler<ActionEvent> handler) {
        myLineColorPicker.setOnAction(handler);
    }

    public Color getSelectedLineColor () {
        return myLineColorPicker.getValue();
    }

    public void setBackgroundColorPickerHandler (EventHandler<ActionEvent> handler) {
        myBackgroundColorPicker.setOnAction(handler);
    }

    public Color getSelectedBackgroundColor () {
        return myBackgroundColorPicker.getValue();
    }

    public void setHelpButtonHandler () {
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent i) {
                try {
                    Desktop.getDesktop()
                            .browse(new URI("http://www.cs.duke.edu/courses/compsci308/fall16/assign/03_slogo/commands.php"));
                }
                catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setAltTurtleImageHandler (EventHandler<ActionEvent> handler) {
        altTurtleImage.setOnAction(handler);

    }

    public void setLanguageChooserHandler (EventHandler<ActionEvent> handler) {
        languageChooser.setOnAction(handler);

    }

    public String getLanguageSelection () {
        return languageChooser.getValue();
    }

    @Override
    public Node getContent () {
        return myToolBar;
    }
}
