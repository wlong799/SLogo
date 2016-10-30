package model;

import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;
import javafx.collections.ObservableList;


public class SLogoModel {
    private static final String DEFAULT_LANGUAGE = "English";
    private CommandParser myCommandParser;
    private DataStorageManager myData;
    private TurtleStorage myTurtles;

    public SLogoModel () {
        init();
        myCommandParser = new CommandParser(DEFAULT_LANGUAGE, myData, myTurtles);
    }

    public SLogoModel (String language) {
        init();
        myCommandParser = new CommandParser(language, myData, myTurtles);
    }

    public TurtleStorage getTurtles () {
        return myTurtles;
    }

    private void init () {
        myTurtles = new TurtleStorage();
        myData = new DataStorageManager();
    }

    public void parse (String s) {
        String command = s;
        try {
            myCommandParser.parse(s);
        }
        catch (Exception e) {
            command += "\nERROR ENCOUNTERED WHEN PARSING.";
        }
        myData.addHistory(command);
    }

    public boolean noParser () {
        return myCommandParser == null;
    }

    public void setLanguage (String language) {
        myCommandParser = new CommandParser(language, myData, myTurtles);
    }

    public DataStorageManager getData () {
        return myData;
    }

}
