package model;

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
        try {
            myCommandParser.parse(s);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Throw parsing exception");
        }
    }

    public boolean noParser () {
        return myCommandParser == null;
    }

    public void setLanguage (String language) {
        myCommandParser = new CommandParser(language, myTurtle);

    }

}
