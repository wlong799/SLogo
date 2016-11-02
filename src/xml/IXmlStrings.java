package xml;


import java.util.ResourceBundle;

interface IXmlStrings {
    String COMMANDS_VARIABLES_FILENAME = "CommandsAndVariables";
    String SEPARATOR = "_";
    String TIME_SAVING_FORMAT = "HH_mm_ss";

    String RESOURCE_PACKAGE = "resources/xmlNaming";
    ResourceBundle MY_RESOURCES = ResourceBundle.getBundle(RESOURCE_PACKAGE);

    String SAVED_COMMANDS_VARIABLES = MY_RESOURCES.getString("saved_commands_variables");
    String VARIABLE_STORAGE = MY_RESOURCES.getString("variable_storage");
    String VARIABLE_ = MY_RESOURCES.getString("variable_");
    String VARIABLE_NAME = MY_RESOURCES.getString("variable_name");
    String VARIABLE_VALUE = MY_RESOURCES.getString("variable_value");
    String FUNCTION_NAME = MY_RESOURCES.getString("function_name");
    String FUNCTION_BODY = MY_RESOURCES.getString("function_body");
    String FUNCTION_PARAMETERS = MY_RESOURCES.getString("function_parameters");
    String FUNCTION_STORAGE = MY_RESOURCES.getString("function_storage");
    String FUNCTION_ = MY_RESOURCES.getString("function_");

    String BACKGROUND_COLOR = MY_RESOURCES.getString("background_color");
    String LINE_COLOR = MY_RESOURCES.getString("line_color");
    String STARTING_IMAGE = MY_RESOURCES.getString("starting_image");
    String COMMAND_LANGUAGE = MY_RESOURCES.getString("command_language");

    String SPACE = " ";
    String SAVED_WORKSPACE = MY_RESOURCES.getString("saved_workspace");
    String EMPTY = MY_RESOURCES.getString("EMPTY");

}
