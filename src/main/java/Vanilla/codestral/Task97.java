package Vanilla.codestral;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class Task97 {
    public static String executeXPath(String fileName, String xpath) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
        XPath xPath = XPathFactory.newInstance().newXPath();
        return xPath.compile(xpath).evaluate(doc);
    }

    public static void main(String[] args) throws Exception {
        String xpath = args[0];
        String fileName = args[1];
        System.out.println(executeXPath(fileName, xpath));
    }
}