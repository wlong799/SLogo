package dataStorage;

import model.ExpressionNode;
import java.util.Map;


public class CommandVariableStorage {
    private Map<String, String> commandParametersPassedIn;
    private Map<String, ExpressionNode> commandCodeBlock;
}
