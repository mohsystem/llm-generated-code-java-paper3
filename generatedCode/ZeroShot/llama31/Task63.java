package ZeroShot.llama31;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Task63 {

    public static Object processRequest(String raw_data) throws Exception {
        // Decode Base64
        byte[] decodedBytes = Base64.getDecoder().decode(raw_data);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);

        try {
            // Try to parse as JSON
            return new JSONObject(new JSONTokener(decodedString));
        } catch (org.json.JSONException e) {
            try {
                // Try to parse as XML
                InputStream inputStream = new ByteArrayInputStream(decodedString.getBytes());
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                return document;
            } catch (ParserConfigurationException | SAXException ex) {
                throw new Exception("Failed to deserialize data");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String[] testCases = {
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ==", // JSON example
            "PGJhc2U+PHVzZXI+Sm9obiBEb2U8L3VzZXI+PC9iYXNlPg==", // XML example
            "InvalidBase64", // Invalid Base64
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ=", // JSON example
            "PGJhc2U+PHVzZXI+Sm9obiBEb2U8L3VzZXI+PC9iYXNlPg==" // XML example
        };

        for (String testCase : testCases) {
            try {
                Object result = processRequest(testCase);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}