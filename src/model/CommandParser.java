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
import exceptions.CustomCommandException;
import exceptions.InvalidCommandException;
import exceptions.InvalidParenthesesException;


/**
 * 
 * @author Michael Schroeder
 *
 */

public class CommandParser {

    private static final String CLOSE_PAREN = ")";
    private static final String CUSTOM_COMMAND = "MakeUserInstruction";
    private static final String COMMAND = "Command";
    private static final String NO_MATCH = "NO MATCH";
    private List<Entry<String, Pattern>> mySyntax;
    private List<Entry<String, Pattern>> myCommands;
    private TurtleStorage myTurtles;
    private DataStorageManager myData;

    /**
     * Constructs a CommandParser with a specified language, data, and turtles
     * 
     * @param language - language to parse commands in
     * @param data - custom defined variables and functions
     * @param turtles - container for all Turtles, both active and inactive
     */
    public CommandParser (String language, DataStorageManager data, TurtleStorage turtles) {
        myTurtles = turtles;
        mySyntax = new ArrayList<>();
        myCommands = new ArrayList<>();
        myData = data;
        init(language);

    }

    private void init (String language) {
        mySyntax = getPatterns("resources/languages/Syntax");
        myCommands = getPatterns("resources/languages/" + language);
    }

    private List<Entry<String, Pattern>> getPatterns (String syntax) {
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

    /**
     * This method is called by the SLogoModel's parse method, which is called by pressing the
     * submit button the front end. This interaction is set up in ViewModelController
     * 
     * @param command - Command string to parse
     * @return - a double that represents the value obtained by executing the root command
     * @throws Exception
     */
    public double parse (String command) throws Exception {

        Queue<String> commandQueue = makeCommandQueue(command);
        ExpressionTree completeCommand =
                new ExpressionTree(myData, myTurtles);

        AbstractCommand rootCommand = null;

        rootCommand = completeCommand.makeTree(commandQueue);
        System.out.println(rootCommand.toString() + " in parse");
        return rootCommand.execute();

    }

    private Queue<String> getUnlimitedParamCommand (Queue<String> commands)
                                                                            throws InvalidParenthesesException {
        String commandString = commands.poll();
        if (!commands.contains(CLOSE_PAREN)) {
            StringBuilder command = new StringBuilder();
            command.append("( " + commandString);
            commands.stream().forEach(s -> command.append(" " + s));
            throw new InvalidParenthesesException(command.toString());
        }

        Queue<String> parenExpression = new LinkedList<String>();
        while (!commands.peek().equals(CLOSE_PAREN)) {
            parenExpression.add(commands.poll());
        }
        commands.poll();
        Queue<String> newQueue = new LinkedList<String>();

        int size = parenExpression.size();
        for (int i = 0; i < size - 1; i++) {
            newQueue.add(commandString);
            newQueue.add(parenExpression.poll());
        }
        newQueue.add(parenExpression.poll());
        newQueue.addAll(commands);
        commands.clear();
        commands.addAll(newQueue);
        return newQueue;
    }

    private Queue<String> getUserCommand (String command, Queue<String> commands) throws Exception {
        System.out.println("Getting custom command " + command);
        String commandString = myData.getCommand(command);
        List<String> commandParams = myData.getCommandParams(command);
        Queue<String> commandQueue = new LinkedList<String>();
        for (String s : commandParams) {
            String replacement;
            if (isVariable(commands.peek())) {
                replacement = commands.poll();
            }
            else {
                try {
                    replacement = Double
                            .toString(new ExpressionTree(myData, myTurtles)
                                    .makeSubTree(commands).execute());
                }
                catch (ClassNotFoundException ex) {
                    throw new CustomCommandException(command, commandString);
                }
            }
            commandString = commandString.replaceAll(s, replacement);
        }
        Arrays.asList(commandString.split("\n"))
                .forEach(s -> commandQueue.addAll(Arrays.asList(s.split(" ")).stream()
                        .collect(Collectors.toList())));
        Queue<String> finalQueue = createCustomQueue(commandQueue);
        System.out.println(finalQueue + " is the command Queue for command " + command);
        return finalQueue;
    }

    /**
     * @param commandQueue
     * @return
     * @throws Exception
     */
    private Queue<String> createCustomQueue (Queue<String> commandQueue) throws Exception {
        Queue<String> finalQueue = new LinkedList<String>();
        while (!commandQueue.isEmpty()) {
            String comm = commandQueue.poll();
            if (myData.hasCommand(comm)) {
                commandQueue.addAll(getUserCommand(comm, commandQueue));
            }
            else {
                finalQueue.add(comm);
            }
        }
        return finalQueue;
    }

    private Queue<String> makeCommandQueue (String command) throws Exception {
        Queue<String> commands = processCommand(command);
        Queue<String> commandQueue = new LinkedList<String>();
        String prevCommand = "";
        while (!commands.isEmpty()) {
            String rawCommand = commands.poll();
            String symbol = getSymbol(rawCommand, false);
            if (symbol.equals(NO_MATCH)) {
                symbol = getSymbol(rawCommand, true);
                if (symbol.equals(NO_MATCH)) {
                    throw new InvalidCommandException(rawCommand);
                }
                else {
                    if (!symbol.equals(COMMAND) || !myData.hasCommand(rawCommand)) {
                        if (rawCommand.equals("(")) {
                            getUnlimitedParamCommand(commands);
                        }
                        else if (symbol.equals(COMMAND) &&
                                 !prevCommand.equals(CUSTOM_COMMAND)) {
                            throw new InvalidCommandException(rawCommand);
                        }
                        else {
                            commandQueue.add(rawCommand);
                        }
                    }
                    else {
                        System.out.println("custom!");
                        commandQueue.addAll(getUserCommand(rawCommand, commands));
                    }
                }
            }
            else {
                commandQueue.add(symbol);
            }
            prevCommand = symbol;
        }
        return commandQueue;
    }

    /**
     * @param command
     * @return
     */
    private Queue<String> processCommand (String command) {
        List<String> removeComments =
                Arrays.asList(command.split("\n")).stream().filter(s -> !s.trim().startsWith("#"))
                        .collect(Collectors.toCollection(LinkedList::new));
        String comm = String.join("\n", removeComments);
        comm = comm.replaceAll("\n", " ");
        Queue<String> commands =
                Arrays.asList(comm.split("\\s+")).stream()
                        .collect(Collectors.toCollection(LinkedList::new));
        return commands;
    }

    private boolean isVariable (String command) {
        return command.startsWith(":");
    }
    //
    // private boolean isConstant (String command) {
    // for (Entry<String, Pattern> e : mySyntax) {
    // if (match(command, e.getValue())) {
    // return e.getKey().equals("Constant");
    // }
    // }
    // return false;
    // }

    // returns the language's type associated with the given text if one exists
    private String getSymbol (String text, boolean syntax) {
        final String ERROR = NO_MATCH;
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
