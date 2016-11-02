package model;

import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;
import javafx.collections.ObservableList;


/**
 * @author Michael Schroeder
 */
public class SLogoModel {
    private static final String DEFAULT_LANGUAGE = "English";
    private CommandParser myCommandParser;
    private DataStorageManager myData;
    private TurtleStorage myTurtles;
    private String myLanguage;

    public SLogoModel () {
        init();
        myCommandParser = new CommandParser(DEFAULT_LANGUAGE, myData, myTurtles);
        myLanguage = DEFAULT_LANGUAGE;
    }

    public TurtleStorage getTurtles () {
        return myTurtles;
    }

    private void init () {
        myTurtles = new TurtleStorage();
        myData = new DataStorageManager();
    }

    public void parse (String s, boolean storeHistory) {
        if (s == null || s.trim().length() == 0) {
            return;
        }
        String command = s;
        String output = "";
        try {
            output = "OUTPUT: " + (myCommandParser.parse(s));
        }
        catch (Exception e) {
            output = e.getMessage();
        }
        if (storeHistory) {
            myData.addHistory(command + "\n" + output);
        }
    }

    public boolean noParser () {
        return myCommandParser == null;
    }

    public void setLanguage (String language) {
        myLanguage = language;
        myCommandParser = new CommandParser(language, myData, myTurtles);
    }

    public DataStorageManager getData () {
        return myData;
    }

    public String getLanguage () {
        return myLanguage;
    }
}
