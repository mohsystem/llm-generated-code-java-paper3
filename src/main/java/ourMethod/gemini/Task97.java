package ourMethod.gemini;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.File;
import java.io.StringReader;

public class Task97 {

    public static String executeXPath(String xmlFileName, String xpathValue) throws Exception {
        // Construct and parse the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlFileName)));


        // Execute the XPath query
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(xpathValue);
        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nl.getLength(); i++) {
            result.append(nl.item(i).getTextContent());

        }
        return result.toString();

    }

    public static void main(String[] args) throws Exception {
        // Test cases
        String testXml1 = "<tag id='1'>Value1</tag>";
        String testXpath1 = "/tag[@id='1']";
        System.out.println("Test case 1: " + executeXPath(testXml1, testXpath1));

        String testXml2 = "<root><tag id='2'>Value2</tag><tag id='3'>Value3</tag></root>";
        String testXpath2 = "/root/tag[@id='2']";

        System.out.println("Test case 2: " + executeXPath(testXml2, testXpath2));

        String testXml3 = "<data><item id='a'>A</item><item id='b'>B</item></data>";
        String testXpath3 = "/data/item[@id='b']";
        System.out.println("Test case 3: " + executeXPath(testXml3, testXpath3));


        String testXml4 = "<bookstore><book><title lang='eng'>Harry Potter</title><price>29.99</price></book><book><title lang='eng'>Learning XML</title><price>39.95</price></book></bookstore>";
        String testXpath4 = "/bookstore/book[price>30]";

        System.out.println("Test case 4: " + executeXPath(testXml4, testXpath4));
         String testXml5 = "<tag id='1'>Value1</tag>";
        String testXpath5 = "/tag[@id='2']";
        System.out.println("Test case 5: " + executeXPath(testXml5, testXpath5));


    }
}