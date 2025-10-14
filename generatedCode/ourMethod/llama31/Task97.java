package ourMethod.llama31;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

public class Task97 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task97 <xpath> <xml_file>");
            return;
        }

        String xpath = args[0];
        String xmlFile = args[1];

        // Validate file path to prevent path traversal
        if (xmlFile.contains("../") || xmlFile.contains("..\") || xmlFile.startsWith("/") || xmlFile.startsWith("\")) {
            System.out.println("Invalid file path");
            return;
        }

        try {
            // Read XML file
            File inputFile = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Execute XPath query
            XPath xPath = XPathFactory.newInstance().newXPath();
            String query = xpath.replace("{id}", "1"); // Example replacement, adjust as needed
            NodeList nodeList = (NodeList) xPath.compile(query).evaluate(doc, XPathConstants.NODESET);

            // Print results
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(element.getTextContent());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}