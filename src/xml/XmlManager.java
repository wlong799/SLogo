package xml;

import controller.workspace.WorkspaceLoadPreferences;
import dataStorage.DataStorageManager;
import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;


public class XmlManager {
    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private ResourceBundle myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);

    public void saveCommandsVariables(DataStorageManager dataStorage) {
        XmlSaver saver = new XmlSaver();
        saver.saveCommandsVariables(dataStorage);
    }

    public WorkspaceLoadPreferences loadWorkspacePreferences(File givenXml) throws Exception {
        XmlParser parser = new XmlParser();
        Map<String, Object> parsedMap = parser.XmlParse(givenXml);

        Map<String, Object> workspaceMap = (Map<String, Object>) parsedMap.get(myResources.getString("saved_workspace"));

        XmlDataSetter setter = new XmlDataSetter();

        return setter.setWorkspaceLoadPreferences(workspaceMap);
    }

    public void loadAndSetVariablesCommands(File givenXml, DataStorageManager dataStorage) throws Exception {
        XmlParser parser = new XmlParser();
        Map<String, Object> parsedMap = parser.XmlParse(givenXml);

        Map<String, Object> tempMap = (Map<String, Object>) parsedMap.get(myResources.getString("saved_workspace"));

        Map<String,  Map<String, String>> variableMap = (Map<String,  Map<String, String>>) tempMap.get(myResources.getString("variable_storage"));
        Map<String, Map<String, String>> commandMap = (Map<String, Map<String, String>>) tempMap.get(myResources.getString("command_storage"));

        XmlDataSetter setter = new XmlDataSetter();

        dataStorage.setVariableStorage(setter.setValueVariables(variableMap));
        dataStorage.setCommandStorage(setter.setCommandVariables(commandMap));
        System.out.println("Set new Variables and commands from file");
    }
}
