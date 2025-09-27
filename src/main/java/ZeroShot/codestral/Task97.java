package ZeroShot.codestral;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.xpath.XPathExpressionException;

public class Task97 {
    public static String xPathQuery(String xmlFileName, String xpath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        File xmlFile = new File(xmlFileName);
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
        XPath xPath = XPathFactory.newInstance().newXPath();
        return xPath.compile(xpath).evaluate(doc);
    }

    public static void main(String[] args) {
        try {
            System.out.println(xPathQuery(args[0], args[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}