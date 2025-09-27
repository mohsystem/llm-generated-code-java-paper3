package ZeroShot.gemini;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class Task97 {

    public static String executeXPath(String xmlFilePath, String xpathQuery) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(xmlFilePath));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(xpathQuery);

        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nodes.getLength(); i++) {
            result.append(nodes.item(i).getTextContent()).append("\n");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) throws Exception {
        String testXml = "data.xml"; // Example XML file

        System.out.println("Test case 1:");
        System.out.println(executeXPath(testXml, "/data/entry[@id='1']"));

        System.out.println("\nTest case 2:");
        System.out.println(executeXPath(testXml, "/data/entry[@id='2']"));

        System.out.println("\nTest case 3:");
        System.out.println(executeXPath(testXml, "/data/entry[@id='3']"));
        
        System.out.println("\nTest case 4:");
        System.out.println(executeXPath(testXml, "/data/entry[@id='4']"));

        System.out.println("\nTest case 5:");
        System.out.println(executeXPath(testXml, "/data/entry[@id='5']"));


    }
}