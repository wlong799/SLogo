package view.toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;


public class LanguageChooser extends MenuElement {
    private final String NAME = "Change Language";

    private ResourceBundle myUIElements = ResourceBundle.getBundle("resources/myUIElements");
    private final int numLanguages = 8;
    private Menu myMenu;
    private ToggleGroup myToggleGroup;
    private ComboBox<String> myChoices;

    public LanguageChooser() {
        myMenu = new Menu(NAME);
        myToggleGroup = new ToggleGroup();
        for (int i = 1; i < numLanguages + 1; i++) {
            String language = myUIElements.getString("languageChooser" + i);
            RadioMenuItem menuItem = new RadioMenuItem(language);
            menuItem.setUserData(language);
            menuItem.setToggleGroup(myToggleGroup);
            myMenu.getItems().add(menuItem);
        }
    }

    public void setEventHandler(EventHandler<ActionEvent> handler) {
        myMenu.setOnAction(handler);
    }

    public String getSelectedLanguage() {
        if (myToggleGroup.getSelectedToggle() == null) {
            return null;
        }
        return (String)myToggleGroup.getSelectedToggle().getUserData();
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenu;
    }

}
