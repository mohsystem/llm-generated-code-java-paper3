package ZeroShot.gpt4o;
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
    public static String executeXPathQuery(String xmlFilePath, String xpathValue) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expr = xPath.compile("/tag[@id='" + xpathValue + "']");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getTextContent();
            } else {
                return "No result found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing the XML file";
        }
    }

    public static void main(String[] args) {
        String result1 = executeXPathQuery("example1.xml", "value1");
        System.out.println("Result 1: " + result1);

        String result2 = executeXPathQuery("example2.xml", "value2");
        System.out.println("Result 2: " + result2);

        String result3 = executeXPathQuery("example3.xml", "value3");
        System.out.println("Result 3: " + result3);

        String result4 = executeXPathQuery("example4.xml", "value4");
        System.out.println("Result 4: " + result4);

        String result5 = executeXPathQuery("example5.xml", "value5");
        System.out.println("Result 5: " + result5);
    }
}