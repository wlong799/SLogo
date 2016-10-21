package model;

import dataStorage.Turtle;

public class SLogoModel {
    private CommandParser myCommandParser;
    private Turtle myTurtle;
    
    
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

}
