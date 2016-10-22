package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Queue;
import dataStorage.Turtle;
import dataStorage.*;
import model.command.AbstractCommand;
import model.command.Constant;
import model.command.Variable;
import java.util.*;


public class ExpressionTree {

    private ExpressionNode myRoot;
    private Turtle myTurtle;
    private ValueVariableStorage myVariableStorage;
    private CommandVariableStorage myCommandStorage;
    
    public ExpressionTree (Turtle turtle, ValueVariableStorage variables, CommandVariableStorage commands) {
        myTurtle = turtle;
        myVariableStorage = variables;
        myCommandStorage = commands;
    }

    public ExpressionNode makeTree (Queue<String> commands) throws ClassNotFoundException {
        ExpressionNode root = new ExpressionNode();
        String command = commands.poll();
        System.out.println("parsing " + command);
        if (command.equals("[")) {
            return makeCommandList(commands);
        }
        else {
            root.addCommand(makeCommand(commands, command));
        }

        return root;
    }

    private AbstractCommand makeCommand (Queue<String> commands, String command) {
        try {
            Class<?> commandClass = Class.forName("model.command." + command);
            Constructor<?> ctor = commandClass.getDeclaredConstructor(List.class);

            try {

                Object o = createCommandObject(commands, commandClass, ctor);
                return (AbstractCommand) o;
            }
            catch (Exception e) {
                System.out.println("Command " + command);
                System.out.println("new instance didnt work");
                return null;
            }

        }

        /* TODO FILIP: Here, can we see about changing the command object? We already have the command as a string.
         * would be much easier to construct the command with the command with the string as a parameter. Can
         * most easily then use this when calling the "Make" method of when finding the object is a constant
         */
        catch (Exception e) {
            System.out.println("no command class");

            try {
                System.out.println("trying to parse double " + command);
                return new Constant(Double.parseDouble(command));
            }
            catch (Exception ex) {
                // return createUserCommand(command);
                System.out.println("Throw invalid command string");
                Variable var = new Variable(command);
                var.addVariables(myVariableStorage, myCommandStorage);
                return var;
            }

        }
    }

    /**
     * @param commands
     * @param parameters
     * @param commandClass
     * @param ctor
     * @return
     * @throws Exception
     */
    private Object createCommandObject (Queue<String> commands,
                                        Class<?> commandClass,
                                        Constructor<?> ctor) throws Exception {
        List<ExpressionNode> parameters = new ArrayList<ExpressionNode>();
        Object o = ctor.newInstance(parameters);
        System.out.println(o.getClass());
        Method getNumParams = commandClass.getMethod("getNumParameters");
        System.out.println("get num params");
        int paramNum = (int) getNumParams.invoke(o);
        if (paramNum > 0) {
            for (; paramNum > 0; paramNum--) {
                parameters.add(makeTree(commands));
            }
            Method addParams = commandClass.getMethod("setParameters", List.class);
            addParams.invoke(o, parameters);
        }
        addOtherParameters(commandClass, o);
        System.out.println(o.getClass());
        return o;
    }

    private void addOtherParameters (Class<?> commandClass, Object o) throws Exception {
        if (commandClass.getSuperclass().toString().contains("Turtle")) {
            Method setTurtle = commandClass.getMethod("setTurtle", Turtle.class);
            setTurtle.invoke(o, myTurtle);
        }
        else if (commandClass.getSuperclass().toString().contains("HigherOrder")) {
            Method addVariableStorage =
                    commandClass.getMethod("addVariables", ValueVariableStorage.class, CommandVariableStorage.class);
            addVariableStorage.invoke(o, myVariableStorage, myCommandStorage);
        }
    }

    private ExpressionNode makeCommandList (Queue<String> commandQueue) {
        int openBrackets = 1;
        int closedBrackets = 0;
        ExpressionNode root = new ExpressionNode();
        while (closedBrackets != openBrackets) {
            String next = commandQueue.poll();
            if (next.equals("]")) {
                closedBrackets++;
            }
            else if (next.equals("[")) {
                openBrackets++;
                makeCommandList(commandQueue);
            }
            else {
                root.addCommand(makeCommand(commandQueue, next));

            }
        }
        if (commandQueue.size() != 0) {
            System.out.println("THROW EXCEPTION: MALFORMATTED COMMAND STRING");
            return root;
        }
        return root;
    }

    public ExpressionNode getRoot () {
        return myRoot;
    }
}
