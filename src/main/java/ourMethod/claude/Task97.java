package ourMethod.claude;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class Task97 {
    public static String executeXPathQuery(String xmlFilePath, String xpathValue) {
        try {
            // Create DocumentBuilder with security features enabled
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse XML file
            File xmlFile = new File(xmlFilePath);
            if(!xmlFile.exists() || !xmlFile.canRead()) {
                return "Error: Cannot access XML file";
            }
            Document doc = builder.parse(xmlFile);
            
            // Create XPath expression
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            String query = String.format("/tag[@id='%s']", xpathValue.replaceAll("[^a-zA-Z0-9]", ""));
            XPathExpression expr = xpath.compile(query);
            
            // Execute query and get results
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < nodes.getLength(); i++) {
                result.append(nodes.item(i).getTextContent()).append("\\n");
            }
            
            return result.toString();
            
        } catch (Exception e) {
            return "Error processing XML: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java Task97 <xml_file_path> <xpath_value>");
            return;
        }

        String xmlFilePath = args[0];
        String xpathValue = args[1];
        
        String result = executeXPathQuery(xmlFilePath, xpathValue);
        System.out.println(result);
    }
}
