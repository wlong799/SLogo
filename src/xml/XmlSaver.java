package xml;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import dataStorage.CommandStorage;
import dataStorage.DataStorageManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSaver implements IXmlStrings {
    private static final String FILE_PATH = "src/resources/xmlData/";

    private Element createElementWithData(String nodeName, String information, Document doc) {
        Element element = doc.createElement(nodeName);
        element.appendChild(doc.createTextNode(information));

        return element;
    }

    public void saveCommandsVariables(DataStorageManager dataStorage) throws Exception {

//        http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root element
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement(SAVED_COMMANDS_VARIABLES);
        doc.appendChild(rootElement);

        // value variable
        Element variableStorage = doc.createElement(VARIABLE_STORAGE);
        rootElement.appendChild(variableStorage);


        int variableNum = 1;

        Map<String, Double> variableMap = dataStorage.getValueVariableMap();

        System.out.println(variableMap.keySet());

        for (String variableName : variableMap.keySet()) {
            Element variableElement = doc.createElement(VARIABLE_ + Integer.toString(variableNum));

            variableElement.appendChild(createElementWithData
                    (VARIABLE_NAME, variableName, doc));

            variableElement.appendChild(createElementWithData
                    (VARIABLE_VALUE, Double.toString(variableMap.get(variableName)), doc));

            variableStorage.appendChild(variableElement);

            variableNum++;
        }

        if(!(variableStorage.hasChildNodes())) {
            variableStorage.setTextContent("EMPTY");
        }

        // command variable
        Element functionStorage = doc.createElement(FUNCTION_STORAGE);
        rootElement.appendChild(functionStorage);

        int functionNum = 1;

        CommandStorage commandStorage = dataStorage.getCommandStorage();

        Map<String, String> functionMap = commandStorage.getCommandMap();


        for (String functionName : functionMap.keySet()) {
            Element functionElement = doc.createElement(FUNCTION_ + Integer.toString(functionNum));

            functionElement.appendChild(createElementWithData
                    (FUNCTION_NAME, functionName, doc));

            StringBuilder parameters = new StringBuilder();

            for (String oneParameter : commandStorage.getCommandParams(functionName)) {
                parameters.append(oneParameter);
                parameters.append(' ');
            }

            if(parameters.length() <= 0) {
                parameters.append("EMPTY");
            }
            functionElement.appendChild(createElementWithData
                    (FUNCTION_PARAMETERS, parameters.toString().trim(), doc));


            functionElement.appendChild(createElementWithData
                    (FUNCTION_BODY, functionMap.get(functionName), doc));

            functionStorage.appendChild(functionElement);
            functionNum++;
        }

        if(!(functionStorage.hasChildNodes())) {
            functionStorage.setTextContent("EMPTY");
        }

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        SimpleDateFormat currentTime = new SimpleDateFormat(TIME_SAVING_FORMAT);
        String savedFileName = COMMANDS_VARIABLES_FILENAME + SEPARATOR + currentTime.toString();
        StreamResult result = new StreamResult(new File(FILE_PATH + savedFileName));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);

        System.out.println("File saved!");
    }
}