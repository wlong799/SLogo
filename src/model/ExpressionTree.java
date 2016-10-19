package model;

import java.lang.reflect.Constructor;
import java.util.Queue;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class ExpressionTree {

    private ExpressionNode myRoot;

    public ExpressionNode makeTree (Queue<String> commands) throws ClassNotFoundException {
        ExpressionNode root = new ExpressionNode();
        while (!commands.isEmpty()) {
            String command = commands.poll();
            if (command.equals("[")) {

            }
            try {
                Class<?> commandClass = Class.forName("model.command." + command);
                Constructor<?> ctor = commandClass.getDeclaredConstructor(List.class);

            }
            catch (Exception e) {

            }
        }
        return null;
    }

    public ExpressionNode getRoot () {
        return myRoot;
    }
}
