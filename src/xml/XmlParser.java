package xml;

import java.util.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


class XmlParser {
    private static final String BAD_TEXT_NODE = "#text";

    Map<String, Object> XmlParse(File file) throws SAXException, IOException, ParserConfigurationException{
        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        Node root = doc.getDocumentElement();
        HashMap<String, Object> rules = new HashMap<String, Object>();

        rules.put(root.getNodeName(), childMapper(root, null));
        childMapper(root, null);

        return rules;
    }

    //    http://stackoverflow.com/questions/15759796/xml-recursive-node-parser
    private Object childMapper(Node root, Node parent) {
        if (root.hasChildNodes()) {

            HashMap<String, Object> childMap = new HashMap<String, Object>();

//            System.out.println(root.getNodeName());
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                if(!(children.item(i).getNodeName().equals(BAD_TEXT_NODE))){
                    childMap.put(children.item(i).getNodeName(), childMapper(children.item(i), root));
                }

                if(children.item(i).getNodeName().equals(BAD_TEXT_NODE)){
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