package CoT.gemini;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class Task97 {

    public static String executeXPath(String xmlFilePath, String xpathValue) throws Exception {
        // Construct and parse the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(xmlFilePath));

        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
        // Compile the XPath expression
        XPathExpression expr = xpath.compile(xpathValue);

        // Evaluate the XPath expression on the XML document
        String result = expr.evaluate(doc);


        return result;
    }

    public static void main(String[] args) throws Exception {
        // Test cases
        String xmlFile = "data.xml";

        System.out.println(executeXPath(xmlFile, "/data/entry[@id=1]"));
        System.out.println(executeXPath(xmlFile, "/data/entry[@id=2]"));
        System.out.println(executeXPath(xmlFile, "/data/entry[@id=3]"));
        System.out.println(executeXPath(xmlFile, "/data/entry[@id=4]"));
        System.out.println(executeXPath(xmlFile, "/data/entry[@id=5]"));
    }
}