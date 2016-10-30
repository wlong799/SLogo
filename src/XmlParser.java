import java.util.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XmlParser {


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
            childMapper(root, null);

            return rules;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    //    http://stackoverflow.com/questions/15759796/xml-recursive-node-parser
    private Object childMapper(Node root, Node parent) {
        if (root.hasChildNodes()) {

            HashMap<String, Object> childMap = new HashMap<String, Object>();

//            System.out.println(root.getNodeName());
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                if(children.item(i).getNodeName() != "#text"){
                    childMap.put(children.item(i).getNodeName(), childMapper(children.item(i), root));
                }

                if(children.item(i).getNodeName() == "#text"){
                    String nodeValue = children.item(i).getNodeValue().trim();
                    if (nodeValue.length() > 0) {
//                        System.out.println(parent.getNodeName() + "::" + nodeValue);
                        return childMapper(children.item(i), root);
                    }
                }

            }
            return childMap;
        }
        else {
            String nodeValue = root.getNodeValue().trim();
            if (nodeValue.length() > 0) {
//                System.out.println(parent.getNodeName() + "::" + nodeValue);
                return nodeValue;
            }
        }
        return null;
    }
}