package Vanilla.gpt4o;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task61 {
    public static String getRootElement(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes()));
            return document.getDocumentElement().getNodeName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        List<String> testCases = new ArrayList<>();
        testCases.add("<root><child>Content</child></root>");
        testCases.add("<bookstore><book><title>XML</title></book></bookstore>");
        testCases.add("<note><to>User</to><from>AI</from></note>");
        testCases.add("<greeting>Hello, world!</greeting>");
        testCases.add("<data><item id='1'>Item1</item></data>");
        
        for (String xml : testCases) {
            System.out.println("Root element: " + getRootElement(xml));
        }
    }
}