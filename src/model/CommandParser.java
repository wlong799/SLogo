package model;

import java.util.List;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import dataStorage.Turtle;
import dataStorage.*;
import model.command.*;


public class CommandParser {

    private List<Entry<String, Pattern>> mySyntax;
    private List<Entry<String, Pattern>> myCommands;
    private ValueVariableStorage myVariableStorage;
    private CommandVariableStorage myCommandStorage;
    private List<Turtle> myTurtles;
    private DataStorageManager myData;

    public CommandParser (String language, DataStorageManager data, List<Turtle> activeTurtles) {
        mySyntax = new ArrayList<>();
        myCommands = new ArrayList<>();
        myData = data;
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
        ExpressionTree completeCommand =
                new ExpressionTree(myData);
        AbstractCommand rootCommand = null;
        try {
            rootCommand = completeCommand.makeTree(commandQueue);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldnt make tree");
            return 0.0;
        }

        return rootCommand.execute();

    }

    private Queue<String> getUserCommand (String command, Queue<String> commands) throws Exception {
        System.out.println("Getting custom command " + command);
        String commandString = myCommandStorage.getCommand(command);
        
        List<String> commandParams = myCommandStorage.getCommandParams(command);
        Queue<String> commandQueue = new LinkedList<String>();

        for (String s : commandParams) {
            System.out.println("replace " + s + " with value in " + command);
            System.out.println("remaining commands " + commands);
            String replacement;
            if (isVariable(commands.peek())) {
                replacement = commands.poll();
            }
            else {
                replacement = Double
                        .toString(new ExpressionTree(myData)
                                .makeSubTree(commands).execute());
            }
            commandString = commandString.replaceAll(s, replacement);
        }
        
        System.out.println(commandString);
        Arrays.asList(commandString.split("\n"))
                .forEach(s -> commandQueue.addAll(Arrays.asList(s.split(" ")).stream()
                        .collect(Collectors.toList())));
        Queue<String> finalQueue = new LinkedList<String>();
        while(!commandQueue.isEmpty()){
            String comm = commandQueue.poll();
            if(DataStorageManager.get().getCommandVariableStorage().hasCommand(comm)){
                commandQueue.addAll(getUserCommand(comm, commandQueue));
            }
            else{
                finalQueue.add(comm);
            }
        }
        System.out.println(finalQueue + " is the command Queue for command " + command);
        return finalQueue;
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
                    if (!symbol.equals("Command") || !DataStorageManager.get()
                            .getCommandVariableStorage().hasCommand(rawCommand)) {
                        System.out.println("adding " + rawCommand + " to command queue because " +
                                           (!symbol.equals("command") ? "not a command syntax"
                                                                      : "not in command storage"));
                        commandQueue.add(rawCommand);
                    }
                    else {
                        try {
                            System.out.println("custom!");
                            commandQueue.addAll(getUserCommand(rawCommand, commands));
                        }
                        catch (Exception ex) {
                            System.out.println("exception in custom command");
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

    private boolean isVariable (String command) {
        return command.startsWith(":");
    }

    private boolean isConstant (String command) {
        for (Entry<String, Pattern> e : mySyntax) {
            if (match(command, e.getValue())) {
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
        return ERROR;
    }

    // returns true if the given text matches the given regular expression pattern
    private boolean match (String text, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(text).matches();
    }
}
