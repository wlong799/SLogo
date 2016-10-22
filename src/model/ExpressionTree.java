package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Queue;
import dataStorage.Turtle;
import model.command.AbstractCommand;
import model.command.Constant;
import java.util.*;


public class ExpressionTree {

    private ExpressionNode myRoot;
    private Turtle myTurtle;

    public ExpressionTree(Turtle turtle){
        myTurtle = turtle;
    }
    
    public ExpressionNode makeTree (Queue<String> commands) throws ClassNotFoundException {
        ExpressionNode root = new ExpressionNode();
        String command = commands.poll();
        if (command.equals("[")) {
            return makeCommandList(commands);
        }
        else {
            root.addCommand(makeCommand(commands, command));
        }

        return root;
    }

    private AbstractCommand makeCommand (Queue<String> commands, String command) {
        List<ExpressionNode> parameters = new ArrayList<ExpressionNode>();
        try {
            Class<?> commandClass = Class.forName("model.command." + command);
            Constructor<?> ctor = commandClass.getDeclaredConstructor(List.class);

            try {

                Object o = createCommandObject(commands, parameters, commandClass, ctor);
                return (AbstractCommand) o;
            }
            catch (Exception e) {
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
            if (!command.startsWith(":")) {
                return new Constant(Double.parseDouble(command));
            }
            else {
                System.out.println("Found user variable");
                return createUserCommand(command);
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
                                        List<ExpressionNode> parameters,
                                        Class<?> commandClass,
                                        Constructor<?> ctor) throws Exception {
        Object o = ctor.newInstance(new ArrayList<ExpressionNode>());
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
        if(commandClass.getSuperclass().toString().contains("Turtle")){
            Method setTurtle = commandClass.getMethod("setTurtle", Turtle.class);
            setTurtle.invoke(o, myTurtle);
        }
        return o;
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
            return null;
        }
        return root;
    }

    private AbstractCommand createUserCommand (String command) {
        return null;
    }

    public ExpressionNode getRoot () {
        return myRoot;
    }
}
