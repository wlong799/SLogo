package model;

import dataStorage.DataStorageManager;
import dataStorage.Turtle;



public class SLogoModel {
    private static final String DEFAULT_LANGUAGE = "English";
    private CommandParser myCommandParser;
    private Turtle myTurtle;

    public SLogoModel () {
        myTurtle = new Turtle();
        myCommandParser = new CommandParser(DEFAULT_LANGUAGE, myTurtle);
    }

    public SLogoModel (String language) {
        myTurtle = new Turtle();
        myCommandParser = new CommandParser(language, myTurtle);
    }

    public Turtle getTurtle () {
        return myTurtle;
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
        myCommandParser = new CommandParser(language, myTurtle);

    }

}
