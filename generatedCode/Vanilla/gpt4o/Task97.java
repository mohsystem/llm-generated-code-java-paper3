package Vanilla.gpt4o;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

public class Task97 {
    public static String executeXPath(String xmlFile, String xpathExpression) {
        try {
            File file = new File(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            if (nl.getLength() > 0) {
                return nl.item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task97 <xpath> <xmlFile>");
            return;
        }
        String result = executeXPath(args[1], args[0]);
        System.out.println(result);
    }
}