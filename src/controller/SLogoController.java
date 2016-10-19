package controller;

import model.CommandParser;
import model.command.*;

public class SLogoController {
    
    private CommandParser myCommandParser;
    
    public SLogoController(){
        myCommandParser = new CommandParser();
        myCommandParser.addPatterns("resources/languages/English");
        myCommandParser.addPatterns("resources/languages/Syntax");
    }
    
    public void parseText (String[] text) {
        
        for (String s : text) {
            if (s.trim().length() > 0) {
                System.out.println(String.format("%s : %s", s, myCommandParser.getSymbol(s)));
                AbstractCommand c = null;
                try{
                    c = myCommandParser.parse(s);
                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
                if(c!=null){
                    System.out.println(c.toString());
                }
                
            }
        }
        
        
        
        System.out.println();
    }
}
