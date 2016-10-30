import java.util.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XmlParser {





    /**
     * Builds a map of the XML file to access all given rules
     * @param file
     * @return map of given rules for each game
     * @throws SAXException
     * @throws IOException
     */
    public Map<String, Object> XMLparse(File file) throws SAXException, IOException {
        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            Node root = doc.getDocumentElement();
            HashMap<String, Object> rules = new HashMap<String, Object>();

            rules.put(root.getNodeName(), childMapper(root, null));
            return rules;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object childMapper(Node root, Node parent) {
        if (root.hasChildNodes())
        {
            System.out.println(root.getNodeName());
            NodeList childrens = root.getChildNodes();
            for (int i = 0; i < childrens.getLength(); i++)
            {
                childMapper(childrens.item(i), root);
            }//for
        }//fi:root_childrens
        else {
            String nodeValue = root.getNodeValue().trim();
            if (nodeValue.length() > 0){
                System.out.println(parent.getNodeName() + "::" + nodeValue);
            }

        }
}