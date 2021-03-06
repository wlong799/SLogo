package xml;

import controller.workspace.WorkspaceLoadPreferences;
import dataStorage.CommandStorage;
import dataStorage.DataStorageManager;
import dataStorage.VariableStorage;
import exceptions.XmlFormatException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class XmlManager implements IXmlStrings {

    public void saveCommandsVariables (DataStorageManager dataStorage) throws Exception {
        XmlSaver saver = new XmlSaver();
        saver.saveCommandsVariables(dataStorage);
    }

    public WorkspaceLoadPreferences loadWorkspacePreferences (File givenXml) throws Exception {
        XmlParser parser = new XmlParser();
        Map<String, Object> parsedMap = parser.XmlParse(givenXml);

        Map<String, Object> workspaceMap = new HashMap<>();
        try {
            workspaceMap = (Map<String, Object>) parsedMap.get(SAVED_WORKSPACE);
        }
        catch (NullPointerException e) {
            throw new XmlFormatException(SAVED_WORKSPACE);
        }

        XmlDataSetter setter = new XmlDataSetter();

        return setter.setWorkspaceLoadPreferences(workspaceMap);
    }

    public void loadAndSetVariablesCommands (File givenXml,
                                             DataStorageManager dataStorage) throws Exception {
        XmlParser parser = new XmlParser();
        Map<String, Object> parsedMap = parser.XmlParse(givenXml);

        Map<String, Object> tempMap = new HashMap<>();
        try {
            tempMap = (Map<String, Object>) parsedMap.get(SAVED_COMMANDS_VARIABLES);
        }
        catch (NullPointerException e) {
            throw new XmlFormatException(SAVED_COMMANDS_VARIABLES);
        }

        Map<String, Map<String, String>> variableMap = new HashMap<>();
        try {
            variableMap = (Map<String, Map<String, String>>) tempMap.get(VARIABLE_STORAGE);
        }
        catch(ClassCastException e) {
            // do nothing, but give an empty variableMap
        }
        catch (NullPointerException e) {
            throw new XmlFormatException(VARIABLE_STORAGE);
        }

        Map<String, Map<String, String>> commandMap = new HashMap<>();
        try {
            commandMap = (Map<String, Map<String, String>>) tempMap.get(FUNCTION_STORAGE);
        }
        catch(ClassCastException e) {
            // do nothing, but give empty commandMap
        }
        catch (NullPointerException e) {
            throw new XmlFormatException(FUNCTION_STORAGE);
        }

        XmlDataSetter setter = new XmlDataSetter();
        VariableStorage variables = setter.setValueVariables(variableMap);
        CommandStorage commands = setter.setCommandVariables(commandMap);
        addDataToStorage(dataStorage, variables, commands);
        // dataStorage.setVariableStorage(setter.setValueVariables(variableMap));
        // dataStorage.setCommandStorage(setter.setCommandVariables(commandMap));
        ////System.out.println("Set new Variables and commands from file");
    }

    /**
     * @param dataStorage
     * @param variables
     * @param commands
     */
    private void addDataToStorage (DataStorageManager dataStorage,
                                   VariableStorage variables,
                                   CommandStorage commands) {
        for (Entry<String, Double> entry : variables.getVariableMap().entrySet()) {
            dataStorage.setVariable(entry.getKey(), entry.getValue());
        }

        for (Entry<String, String> entry : commands.getCommandMap().entrySet()) {
            dataStorage.setCommand(entry.getKey(), commands.getCommandParams(entry.getKey()),
                                   entry.getValue());
        }
    }

}
