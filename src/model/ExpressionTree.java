package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import dataStorage.Turtle;
import dataStorage.*;
import model.command.AbstractCommand;
import model.command.ListCommand;
import model.command.higherOrderCommands.Variable;

import java.util.*;


public class ExpressionTree {
    private ResourceBundle myCommandPaths;
    private String myCommandPathsPath = "resources/commandPaths";
    private Turtle myTurtle;
    private ValueVariableStorage myVariableStorage;
    private CommandVariableStorage myCommandStorage;

    public ExpressionTree (Turtle turtle,
                           ValueVariableStorage variables,
                           CommandVariableStorage commands) {
        myTurtle = turtle;
        myVariableStorage = variables;
        myCommandStorage = commands;
        myCommandPaths = ResourceBundle.getBundle(myCommandPathsPath);
    }

    public AbstractCommand makeTree (Queue<String> commands) throws ClassNotFoundException {
        List<AbstractCommand> commandList = new ArrayList<AbstractCommand>();
        while (!commands.isEmpty()) {
            commandList.add(makeSubTree(commands));
        }
        return new ListCommand(commandList);
    }


    public AbstractCommand makeSubTree (Queue<String> commands) throws ClassNotFoundException {
        String command = commands.poll();
        System.out.println("parsing string: " + command);
        // AbstractCommand rootCommands = null;
        if (command.equals("[")) {
            return makeCommandList(commands);
        }
        else {
            return makeCommand(commands, command);
        }
    }

    private AbstractCommand makeCommand (Queue<String> commands, String command) {
        try {
            Class<?> commandClass = Class.forName(myCommandPaths.getString(command));
            Constructor<?> ctor = commandClass.getDeclaredConstructor(List.class);

            try {

                Object o = createCommandObject(commands, commandClass, ctor);
                return (AbstractCommand) o;
            }
            catch (Exception e) {
                System.out.println("Failed to instantiate " + command);
                e.printStackTrace();
                return null;
            }

        }

        /*
         * TODO FILIP: Here, can we see about changing the command object? We already have the
         * command as a string.
         * would be much easier to construct the command with the command with the string as a
         * parameter. Can
         * most easily then use this when calling the "Make" method of when finding the object is a
         * constant
         */
        catch (Exception e) {
            System.out.println("Could not create command of class " + command);

            try {
                System.out.println("Trying to create constant " + command);
                return new Constant(Double.parseDouble(command));
            }
            catch (Exception ex) {
                // return createUserCommand(command);
                System.out.println("Could not create a constant. Creating variable " + command);
                Variable var = new Variable(command);
                var.addVariables(myVariableStorage, myCommandStorage);
                return var;
            }

        }
    }

    /**
     * @param commands
     * @param commandClass
     * @param ctor
     * @return
     * @throws Exception
     */
    private Object createCommandObject (Queue<String> commands,
                                        Class<?> commandClass,
                                        Constructor<?> ctor) throws Exception {
        List<AbstractCommand> parameters = new ArrayList<AbstractCommand>();
        Object o = ctor.newInstance(parameters);
        System.out.println(o.getClass());
        Method getNumParams = commandClass.getMethod("getNumParameters");
        System.out.println("get num params");
        int paramNum = (int) getNumParams.invoke(o);
        if (paramNum > 0) {
            for (; paramNum > 0; paramNum--) {
                parameters.add(makeSubTree(commands));
            }
            Method addParams = commandClass.getMethod("setParameters", List.class);
            addParams.invoke(o, parameters);
        }
        addOtherParameters(commandClass, o);
        System.out.println(o.getClass());
        System.out.println(parameters);
        return o;
    }

    private void addOtherParameters (Class<?> commandClass, Object o) throws Exception {
        if (commandClass.getSuperclass().toString().contains("Turtle")) {
            Method setTurtle = commandClass.getMethod("setTurtle", Turtle.class);
            setTurtle.invoke(o, myTurtle);
        }
        else if (commandClass.getSuperclass().toString().contains("HigherOrder")) {
            Method addVariableStorage =
                    commandClass.getMethod("addVariables", ValueVariableStorage.class,
                                           CommandVariableStorage.class);
            addVariableStorage.invoke(o, myVariableStorage, myCommandStorage);
        }
    }

    private ListCommand makeCommandList (Queue<String> commandQueue) {
        int openBrackets = 1;
        int closedBrackets = 0;
        System.out.println("Creating command list of " + commandQueue);
        List<AbstractCommand> commandList = new ArrayList<AbstractCommand>();
        while (closedBrackets != openBrackets) {
            String next = commandQueue.poll();
            if (next.equals("]")) {
                closedBrackets++;
            }
            else if (next.equals("[")) {
                // openBrackets++;
                commandList.add(makeCommandList(commandQueue));
            }
            else if (next.equals(" ")){
                continue;
            }
            else {
                commandList.add(makeCommand(commandQueue, next));
            }
        }
        ListCommand command = new ListCommand(commandList);
        return command;
    }
}
