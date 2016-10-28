package model;

import dataStorage.DataStorageManager;
import dataStorage.Turtle;



public class SLogoModel {
    private static final String DEFAULT_LANGUAGE = "English";
    private CommandParser myCommandParser;
    private DataStorageManager myData;
    
    public SLogoModel () {
        myCommandParser = new CommandParser(DEFAULT_LANGUAGE, myData);
        myData = new DataStorageManager();
    }

    public SLogoModel (String language) {
        myData = new DataStorageManager();
        myCommandParser = new CommandParser(language, myData);
    }

    public Turtle getTurtle () {
        return myData.getTurtle();
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

}
