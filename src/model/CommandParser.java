package model;

import java.util.List;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import model.command.*;


public class CommandParser {
    private List<Entry<String, Pattern>> mySymbols;

    public CommandParser () {
        mySymbols = new ArrayList<>();
    }

    public void addPatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            mySymbols.add(new SimpleEntry<>(key,
                                            // THIS IS THE IMPORTANT LINE
                                            Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }
    public AbstractCommand parse(String command) throws ClassNotFoundException{
        
        
        String symbol = getSymbol(command);
        ArrayList<Integer> params = new ArrayList<Integer>();
        params.add(0);
        System.out.println(params.getClass());
        System.out.println(List.class);
        Class<?> clazz = Class.forName((!symbol.equals("NO MATCH")) ? "model.command."+symbol+"Command" : "java.lang.String");
        AbstractCommand c = null;
        try {
            //clazz.getMethod("execute").getParameterCount();
            Constructor<?> ctor = clazz.getDeclaredConstructor(List.class);
            Object o = ctor.newInstance(params);
            System.out.println("Printing: " + o);
            c = (AbstractCommand)o;
        }
        catch(Exception e) {
            
            e.printStackTrace();
        }
        return c;
        
    }
    // returns the language's type associated with the given text if one exists
    public String getSymbol (String text) {
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : mySymbols) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        return ERROR;
    }
    
    // returns true if the given text matches the given regular expression pattern
    private boolean match (String text, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(text).matches();
    }
}
