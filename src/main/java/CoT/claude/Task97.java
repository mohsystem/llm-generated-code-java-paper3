package CoT.claude;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import org.w3c.dom.Document;
import java.io.File;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.NodeList;

public class Task97 {
    public static String executeXPathQuery(String xmlFilePath, String xpathQuery) {
        try {
            // Input validation
            if (xmlFilePath == null || xpathQuery == null || xmlFilePath.isEmpty() || xpathQuery.isEmpty()) {
                return "Invalid input parameters";
            }

            // Create secure parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Validate file exists and is readable
            File xmlFile = new File(xmlFilePath);
            if (!xmlFile.exists() || !xmlFile.canRead()) {
                return "Cannot access XML file";
            }
            
            // Parse XML securely
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            // Create XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            XPathExpression expr = xpath.compile(xpathQuery);
            
            // Execute query
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            
            // Format results
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nodes.getLength(); i++) {
                result.append(nodes.item(i).getTextContent()).append("\\n");
            }
            
            return result.toString();
            
        } catch (Exception e) {
            return "Error processing XML: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testXmls = {
            "test1.xml",
            "test2.xml", 
            "test3.xml",
            "test4.xml",
            "test5.xml"
        };
        
        String[] testQueries = {
            "/books/book[@id='1']",
            "/users/user[@id='admin']",
            "/products/product[@id='123']",
            "/orders/order[@id='ORDER001']",
            "/employees/employee[@id='EMP100']"
        };
        
        for(int i = 0; i < 5; i++) {
            System.out.println("Test Case " + (i+1) + ":");
            System.out.println(executeXPathQuery(testXmls[i], testQueries[i]));
            System.out.println();
        }
    }
}
