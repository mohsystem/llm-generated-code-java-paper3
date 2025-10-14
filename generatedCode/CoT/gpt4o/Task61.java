package CoT.openai;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Task61 {
    public static String getRootElement(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream is = new ByteArrayInputStream(xmlString.getBytes());
            Document document = builder.parse(is);
            Element root = document.getDocumentElement();
            return root.getNodeName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getRootElement("<root><child></child></root>")); // root
        System.out.println(getRootElement("<data><item></item></data>"));   // data
        System.out.println(getRootElement("<book><title></title></book>")); // book
        System.out.println(getRootElement("<note><to></to></note>"));       // note
        System.out.println(getRootElement("<library><books></books></library>")); // library
    }
}