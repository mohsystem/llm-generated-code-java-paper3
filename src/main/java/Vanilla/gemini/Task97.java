package Vanilla.gemini;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import java.io.File;

public class Task97 {

    public static String executeXPath(String xmlFilePath, String xpathValue) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(xmlFilePath));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(xpathValue);

        String result = expr.evaluate(doc);
        return result;

    }

    public static void main(String[] args) throws Exception {
        String testXml = "<root><tag id=\"1\">Value1</tag><tag id=\"2\">Value2</tag></root>";
        File tempFile = File.createTempFile("temp", ".xml");
        java.nio.file.Files.writeString(tempFile.toPath(), testXml);
        String xmlFilePath = tempFile.getAbsolutePath();



        System.out.println(executeXPath(xmlFilePath, "/root/tag[@id='1']")); // Value1
        System.out.println(executeXPath(xmlFilePath, "/root/tag[@id='2']")); // Value2
        System.out.println(executeXPath(xmlFilePath, "/root/tag[@id='3']")); // 
        System.out.println(executeXPath(xmlFilePath, "/root/tag")); // Value1Value2
        System.out.println(executeXPath(xmlFilePath, "/root")); // 


        tempFile.delete();
    }
}