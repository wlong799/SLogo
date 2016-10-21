package model;

import java.util.List;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Constructor;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import dataStorage.Turtle;
import dataStorage.VariableStorage;
import model.command.*;


public class CommandParser {

    private List<Entry<String, Pattern>> mySyntax;
    private List<Entry<String, Pattern>> myCommands;
    private VariableStorage myVariableStorage;
    private Turtle myTurtle;

    public CommandParser (String language, Turtle turtle) {
        mySyntax = new ArrayList<>();
        myCommands = new ArrayList<>();
        myVariableStorage = new VariableStorage();
        myTurtle = turtle;
        init(language);

    }

    public void init (String language) {
        mySyntax = getPatterns("resources/languages/Syntax");
        myCommands = getPatterns("resources/languages/" + language);
    }

    public List<Entry<String, Pattern>> getPatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        List<Entry<String, Pattern>> patterns = new ArrayList<Entry<String, Pattern>>();
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            patterns.add(new SimpleEntry<>(key,
                                           // THIS IS THE IMPORTANT LINE
                                           Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return patterns;
    }

    public double parse (String command) throws Exception {

        Queue<String> commandQueue = makeCommandQueue(command);
        ExpressionTree completeCommand = new ExpressionTree(myTurtle, myVariableStorage);
        ExpressionNode node = null;
        try {
            node = completeCommand.makeTree(commandQueue);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldnt make tree");
            return 0.0;
        }

        return traverse(node);

    }

    private List<String> getUserCommand (String command, Queue<String> commands) throws Exception {
        String commandString = myVariableStorage.getCommand(command);
        List<String> commandParams = myVariableStorage.getCommandParams(command);

        List<String> commandQueue = new LinkedList<String>();
        Arrays.asList(commandString.split("\n"))
                .forEach(s -> commandQueue.addAll(Arrays.asList(s.split(" ")).stream()
                        .collect(Collectors.toList())));
        if (!commands.poll().equals("[")) {
            throw new Exception("Invalid custom command");
        }
        ;
        for (String s : commandParams) {
            myVariableStorage.setVariable(s,
                                          traverse(new ExpressionTree(myTurtle, myVariableStorage)
                                                  .makeTree(commands)));
        }
        return commandQueue;
    }

    private Queue<String> makeCommandQueue (String command) {
        List<String> onOneLine = Arrays.asList(command.split("\\n"));

        Queue<String> commands = new LinkedList<String>();
        onOneLine.forEach(s -> commands.addAll(Arrays.asList(s.split(" "))));
        Queue<String> commandQueue = new LinkedList<String>();
        while (!commands.isEmpty()) {
            String rawCommand = commands.poll();
            String symbol = getSymbol(rawCommand, false);
            if (symbol.equals("NO MATCH")) {
                symbol = getSymbol(rawCommand, true);
                if (symbol.equals("NO MATCH")) {
                    System.out.println("Throw Invalid Command Exception");

                }
                else {
                    if (symbol.equals("Variable")) {
                        commandQueue
                                .add(Double.toString(myVariableStorage.getVariable(rawCommand)));
                    }
                    else {
                        if(!symbol.equals("Command")){
                            commandQueue.add(rawCommand);
                        }
                        else{
                            try{
                                commandQueue.addAll(getUserCommand(rawCommand, commands));
                            }
                            catch(Exception ex){
                                System.out.println("exception in custom command");
                            }
                        }
                    }
                }
            }
            else {
                commandQueue.add(symbol);
            }
        }
        return commandQueue;
    }

    private double traverse (ExpressionNode root) {
        double output = 0.0;
        for (int i = 0; i < root.getCommands().size(); i++) {
            System.out.println(root.getCommands().get(i).getClass());
            output = root.getCommands().get(i).execute();
        }
        return output;
    }

    private boolean isVariable (String command) {
        return command.startsWith(":");
    }

    private boolean isConstant (String command){
        for(Entry<String, Pattern> e : mySyntax){
            if(match(command, e.getValue())){
                return e.getKey().equals("Constant");
            }
        }
        return false;
    }
    // returns the language's type associated with the given text if one exists
    public String getSymbol (String text, boolean syntax) {
        final String ERROR = "NO MATCH";
        List<Entry<String, Pattern>> myMatchStrings = syntax ? mySyntax : myCommands;
        for (Entry<String, Pattern> e : myMatchStrings) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        for (Entry<String, Pattern> e : myCommands) {

        }
        return ERROR;
    }

    // returns true if the given text matches the given regular expression pattern
    private boolean match (String text, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(text).matches();
    }
}
