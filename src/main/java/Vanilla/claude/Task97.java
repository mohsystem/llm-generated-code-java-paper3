package Vanilla.claude;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

public class Task97 {
    public static String executeXPath(String xmlFile, String xpath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));
            
            XPath xPath = XPathFactory.newInstance().newXPath();
            String query = String.format("/tag[@id='%s']", xpath);
            NodeList nodeList = (NodeList) xPath.evaluate(query, doc, XPathConstants.NODESET);
            
            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getTextContent();
            }
            return "No match found";
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testXmls = {
            "test1.xml", "test2.xml", "test3.xml", "test4.xml", "test5.xml"
        };
        String[] testXpaths = {
            "1", "2", "3", "4", "5"
        };
        
        for(int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i+1) + ": " + 
                executeXPath(testXmls[i], testXpaths[i]));
        }
    }
}
