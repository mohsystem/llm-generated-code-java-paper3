package CoT.gpt4o;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
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
            File inputFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression expr = xPath.compile(xpathValue);
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nodeList.getLength(); i++) {
                result.append(nodeList.item(i).getTextContent()).append("\n");
            }
            return result.toString().trim();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String xmlFilePath = "example.xml"; // Replace with actual XML file path
        String xpathValue = "/tag[@id='1']"; // Replace with actual XPath

        // Test cases
        System.out.println(executeXPathQuery(xmlFilePath, xpathValue));
        System.out.println(executeXPathQuery("another_example.xml", "/tag[@id='2']"));
        System.out.println(executeXPathQuery("example.xml", "/tag[@id='3']"));
        System.out.println(executeXPathQuery("wrongfile.xml", "/tag[@id='1']"));
        System.out.println(executeXPathQuery("example.xml", "/wrongtag[@id='1']"));
    }
}