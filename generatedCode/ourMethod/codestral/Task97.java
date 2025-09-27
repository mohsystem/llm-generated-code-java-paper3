package ourMethod.codestral;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Task97 {
    public static void main(String[] args) {
        String xpathExpression = args[0];
        String xmlFileName = args[1];

        try {
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            String result = xPath.compile(xpathExpression).evaluate(doc);

            System.out.println("Result: " + result);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}