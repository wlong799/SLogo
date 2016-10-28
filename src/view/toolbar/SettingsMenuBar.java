package view.toolbar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import view.GUIElement;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SettingsMenuBar extends GUIElement {
    private ResourceBundle myUIElements;
    private String myUIElementsPath = "resources/myUIElements";
    private MenuBar myMenuBar;
    private ColorPicker myBackgroundColorPicker;
    private ColorPicker myLineColorPicker;
    private Button altTurtleImage;
    private ComboBox<String> languageChooser;
    private Button helpButton;
    private int number_of_languages = 8;


    public SettingsMenuBar() {
        myUIElements = ResourceBundle.getBundle(myUIElementsPath);
        myMenuBar = new MenuBar();
/*
        myLineColorPicker = new ColorPicker(Color.BLACK);
        MenuItem myLineColorPickerItem = new MenuItem(null, myLineColorPicker);
        menuView.getItems().add(myLineColorPickerItem);

        myBackgroundColorPicker = new ColorPicker();
        MenuItem myBackgroundColorPickerItem = new MenuItem("Background" , myBackgroundColorPicker);
        menuView.getItems().add(myBackgroundColorPickerItem);

        languageChooser = createComboBox("languageChooser", number_of_languages);
        languageChooser.setValue("English");
        MenuItem languageChooserItem = new MenuItem(null,languageChooser);
        menuFile.getItems().add(languageChooserItem);

        altTurtleImage = createButton("altTurtleImage");
        MenuItem altTurtleImageItem = new MenuItem(null, altTurtleImage);
        menuView.getItems().add(altTurtleImageItem);

        helpButton = createButton("helpButton");
        MenuItem helpButtonItem = new MenuItem(null, helpButton);
        setHelpButtonHandler();
        menuHelp.getItems().add(helpButtonItem);*/
    }

    @Override
    public Node getContent() {
        return myMenuBar;
    }

    public void addMenu(AbstractMenu element) {
        myMenuBar.getMenus().add(element.getMenu());
    }

    private ComboBox<String> createComboBox(String description, int numberOfOptions) {
        List<String> options = new ArrayList<>();

        for (int i = 1; i < numberOfOptions + 1; i++) {
            String temp = myUIElements.getString(description + Integer.toString(i));
            if (!temp.equals(null)) {
                options.add(temp);
            }
        }

        ComboBox<String> box = new ComboBox<>();
        box.getItems().addAll(options.toArray(new String[options.size()]));
        return box;
    }

    private Button createButton(String description) {

        Button ret = new Button();
        String retText = myUIElements.getString(description);
        ret.setText(retText);

        DropShadow effect = new DropShadow();
        ret.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ret.setEffect(effect);
            }
        });

        ret.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ret.setEffect(null);
            }
        });

        return ret;

    }

    public void setLineColorPickerHandler(EventHandler<ActionEvent> handler) {
        myLineColorPicker.setOnAction(handler);
    }

    public Color getSelectedLineColor() {
        return myLineColorPicker.getValue();
    }

    public void setBackgroundColorPickerHandler(EventHandler<ActionEvent> handler) {
        myBackgroundColorPicker.setOnAction(handler);
    }

    public Color getSelectedBackgroundColor() {
        return myBackgroundColorPicker.getValue();
    }

    public void setHelpButtonHandler() {
        helpButton.setOnAction(i -> {
            try {
                Desktop.getDesktop().browse(new URI("http://www.cs.duke.edu/courses/compsci308/fall16/assign/03_slogo/commands.php"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

    public void setAltTurtleImageHandler(EventHandler<ActionEvent> handler) {
        altTurtleImage.setOnAction(handler);

    }

    public void setLanguageChooserHandler(EventHandler<ActionEvent> handler) {
        languageChooser.setOnAction(handler);

    }

    public String getLanguageSelection() {
        return languageChooser.getValue();
    }
}
