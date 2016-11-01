package xml;

import controller.workspace.WorkspaceLoadPreferences;
import dataStorage.DataStorageManager;
import exceptions.XmlFormatException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class XmlManager {
    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private static final ResourceBundle MY_RESOURCES = ResourceBundle.getBundle(RESOURCE_PACKAGE);

    private static final String SAVED_WORKSPACE = MY_RESOURCES.getString("saved_workspace");
    private static final String SAVED_COMMANDS_VARIABLES = MY_RESOURCES.getString("saved_commands_variables");
    private static final String VARIABLE_STORAGE = MY_RESOURCES.getString("variable_storage");
    private static final String COMMAND_STORAGE = MY_RESOURCES.getString("command_storage");

    public void saveCommandsVariables(DataStorageManager dataStorage) {
        XmlSaver saver = new XmlSaver();
        saver.saveCommandsVariables(dataStorage);
    }

    public WorkspaceLoadPreferences loadWorkspacePreferences(File givenXml) throws Exception {
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

    public void loadAndSetVariablesCommands(File givenXml, DataStorageManager dataStorage) throws Exception {
        XmlParser parser = new XmlParser();
        Map<String, Object> parsedMap = parser.XmlParse(givenXml);

        Map<String, Object> tempMap = new HashMap<>();
        try {
            tempMap = (Map<String, Object>) parsedMap.get(SAVED_COMMANDS_VARIABLES);
        }
        catch(NullPointerException e) {
            throw new XmlFormatException(SAVED_COMMANDS_VARIABLES);
        }

        Map<String,  Map<String, String>> variableMap = new HashMap<>();
        try{
            variableMap = (Map<String,  Map<String, String>>) tempMap.get(VARIABLE_STORAGE);
        }
        catch(NullPointerException e) {
            throw new XmlFormatException(VARIABLE_STORAGE);
        }

        Map<String, Map<String, String>> commandMap = new HashMap<>();
        try {
            commandMap = (Map<String, Map<String, String>>) tempMap.get(COMMAND_STORAGE);
        }
        catch(NullPointerException e) {
            throw new XmlFormatException(COMMAND_STORAGE);
        }

        XmlDataSetter setter = new XmlDataSetter();

        dataStorage.setVariableStorage(setter.setValueVariables(variableMap));
        dataStorage.setCommandStorage(setter.setCommandVariables(commandMap));
        System.out.println("Set new Variables and commands from file");
    }
}
