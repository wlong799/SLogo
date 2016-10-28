package model;

import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;



public class SLogoModel {
    private static final String DEFAULT_LANGUAGE = "English";
    private CommandParser myCommandParser;
    private DataStorageManager myData;
    private TurtleStorage myTurtles;
    
    public SLogoModel () {
        myCommandParser = new CommandParser(DEFAULT_LANGUAGE, myData);
        myData = new DataStorageManager();
    }

    public SLogoModel (String language) {
        myData = new DataStorageManager();
        myCommandParser = new CommandParser(language, myData);
    }

    public void parse (String s) {
        String command = s;
        try {
            myCommandParser.parse(s);
        }
        catch (Exception e) {
            command += "\nERROR ENCOUNTERED WHEN PARSING.";
        }
        DataStorageManager.get().getCommandHistoryStorage().addCommand(command);
    }

    public boolean noParser () {
        return myCommandParser == null;
    }

    public void setLanguage (String language) {
        myCommandParser = new CommandParser(language, myData);
    }
    
    public DataStorageManager getData() {
        return myData;
    }
    
    public List<Turtle> getActiveTurtles () {
        return myTurtles.getActiveTurtles();
    }

}
