package model;

import dataStorage.Turtle;
import dataStorage.VariableStorage;

public class SLogoModel {
    private static final String DEFAULT_LANGUAGE = "English";
    private CommandParser myCommandParser;
    private Turtle myTurtle;
    private VariableStorage myVariableStorage;
    
    public SLogoModel(){
        myTurtle = new Turtle();
        myCommandParser = new CommandParser(DEFAULT_LANGUAGE);
    }
    
    public SLogoModel(String language){
        myTurtle = new Turtle();
        myCommandParser = new CommandParser(language);
    }
    
    public Turtle getTurtle() {
        return myTurtle;
    }
    
    public void parse(String s){
        try{
            myCommandParser.parse(s, myTurtle);
        }
        catch(Exception e){
            System.out.println("Throw parsing exception");
        }
    }
    
    public boolean noParser() {
        return myCommandParser == null;
    }
    public void setLanguage(String language){
        myCommandParser = new CommandParser(language);
    }

}
