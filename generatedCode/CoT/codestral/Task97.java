package CoT.codestral;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class Task97 {
    public static String executeXPath(String xpath, String xmlFileName) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlFileName));
        XPath xPath = XPathFactory.newInstance().newXPath();
        return xPath.compile(xpath).evaluate(doc);
    }

    public static void main(String[] args) {
        try {
            System.out.println(executeXPath(args[0], args[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}