package view.toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class LanguageChooser extends MenuElement {
	
	private ResourceBundle myUIElements = ResourceBundle.getBundle("resources/myUIElements"); 
	private final int numLanguages = 8;
	private Menu myMenu;
	private MenuItem myMenuItem;
	private final String NAME = "Change Language";
	private ComboBox<String> myChoices;
	
	public LanguageChooser(EventHandler<ActionEvent> handler){
		//ArrayList<String> langs = new ArrayList<String>();
		
		List<String> langs = new ArrayList<>();
		for(int i = 1; i<numLanguages+1; i++){
			langs.add(myUIElements.getString("languageChooser"+i));
		}
		myChoices = new ComboBox<>();
        myChoices.getItems().addAll(langs.toArray(new String[langs.size()]));
        myChoices.setOnAction(handler);
        myChoices.setValue("English");
        myMenuItem = new Menu(NAME, myChoices);
		
        //ObservableList<String> langsList = FXCollections.observableArrayList(langs);
		//myMenu.getItems().add((MenuItem) langsList);
		
	}
	
	@Override
	public MenuItem getMenuItem() {
		// TODO Auto-generated method stub
		return myMenu;
	}
	
	

}
