package ZeroShot.claude;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import org.w3c.dom.Document;
import java.io.File;

public class Task97 {
    public static String executeXPathQuery(String xmlFilePath, String xpathQuery) {
        try {
            // Create secure XML parser with disabled external entities
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            dbf.setXIncludeAware(false);
            dbf.setExpandEntityReferences(false);
            
            DocumentBuilder builder = dbf.newDocumentBuilder();
            
            // Parse XML file
            File xmlFile = new File(xmlFilePath);
            if(!xmlFile.exists() || !xmlFile.canRead()) {
                return "Error: Cannot access XML file";
            }
            Document doc = builder.parse(xmlFile);
            
            // Create XPath object
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            
            // Compile and evaluate XPath
            XPathExpression expr = xpath.compile(xpathQuery);
            String result = expr.evaluate(doc);
            
            return result.isEmpty() ? "No result found" : result;
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"sample.xml", "/root[@id='1']"},
            {"test.xml", "/users/user[@id='123']"},
            {"data.xml", "/books/book[@id='B001']"},
            {"invalid.xml", "/root[@id='1']"},
            {"sample.xml", "/invalid[@id='999']"}
        };
        
        for(String[] test : testCases) {
            System.out.println("XML File: " + test[0]);
            System.out.println("XPath Query: " + test[1]);
            System.out.println("Result: " + executeXPathQuery(test[0], test[1]));
            System.out.println("------------------------");
        }
    }
}
