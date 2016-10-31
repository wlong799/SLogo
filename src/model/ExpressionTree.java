package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import dataStorage.Turtle;
import dataStorage.*;
import model.command.AbstractCommand;
import model.command.ListCommand;
import model.command.higherOrderCommands.Variable;
import model.command.zeroParameter.Constant;
import java.util.*;


/**
 * 
 * @author Michael Schroeder
 *
 */

public class ExpressionTree {
    private ResourceBundle myCommandPaths;
    private String myCommandPathsPath = "resources/commandPaths";
    private TurtleStorage myTurtles;
    private DataStorageManager myData;

    /**
     * Creates an Expression Tree with variables, commands and turtles
     * 
     * @param data - the container for all variables, commands and notifications
     * @param turtles - the container for all Turtles, both active and inactive
     */
    public ExpressionTree (DataStorageManager data, TurtleStorage turtles) {
        myData = data;
        myTurtles = turtles;
        myCommandPaths = ResourceBundle.getBundle(myCommandPathsPath);
    }

    /**
     * Creates the expression tree from the command queue
     * 
     * @param commands - list of commands to create the tree from
     * @return - AbstractCommand that is a list of all of the command trees. Executing this
     *         command executes the entire tree of commands
     * @throws ClassNotFoundException
     */
    public AbstractCommand makeTree (Queue<String> commands) throws ClassNotFoundException {
        List<AbstractCommand> commandList = new ArrayList<AbstractCommand>();
        while (!commands.isEmpty()) {
            commandList.add(makeSubTree(commands));
        }
        return new ListCommand(commandList);
    }

    /**
     * This makes a single tree (rather than a list) that will be executed by executing the returned
     * root command
     * 
     * @param commands - list of commands to create the tree from
     * @return - AbstractCommand that is the root of the expression tree.
     * @throws ClassNotFoundException
     */
    public AbstractCommand makeSubTree (Queue<String> commands) throws ClassNotFoundException {
        String command = commands.poll();
        System.out.println("parsing string: " + command);
        // AbstractCommand rootCommands = null;
        if (command.equals("[")) {
            return makeCommandList(commands);
        }
//        else if (command.equals("(")) {
//            return makeUnlimitedCommand(commands);
//        }
        else {
            return makeCommand(commands, command);
        }
    }
//
//    private AbstractCommand makeUnlimitedCommand (Queue<String> commands) {
//        String commandString = commands.poll();
//        Queue<String> newQueue = new LinkedList<String>();
//        int size = commands.size();
//        for (int i = 0; i < size - 2; i++) {
//            newQueue.add(commandString);
//            newQueue.add(commands.poll());
//        }
//        newQueue.add(commands.poll());
//        try {
//            AbstractCommand command = makeSubTree(newQueue);
//            return makeSubTree(newQueue);
//        }
//        catch (Exception e) {
//            return null;
//        }
//    }

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
        catch (Exception e) {
            System.out.println("Could not create command of class " + command);
            e.printStackTrace();
            try {
                System.out.println("Trying to create constant " + command);
                return new Constant(Double.parseDouble(command));
            }
            catch (Exception ex) {
                // return createUserCommand(command);
                System.out.println("Could not create a constant. Creating variable " + command);
                Variable var = new Variable(command);
                var.addOtherParameters(myData, myTurtles);
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
        Method addOtherParameters =
                commandClass.getMethod("addOtherParameters", DataStorageManager.class,
                                       TurtleStorage.class);
        addOtherParameters.invoke(o, myData, myTurtles);

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
            else if (next.equals(" ")) {
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
