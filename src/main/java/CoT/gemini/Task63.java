package CoT.gemini;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import com.google.gson.Gson; // Example using Gson for JSON deserialization

public class Task63 {

    public static Object processRequest(String rawData, String format) throws UnsupportedEncodingException {
        byte[] utf8Bytes = rawData.getBytes("UTF-8");
        byte[] decodedBytes = Base64.getDecoder().decode(utf8Bytes);
        String decodedString = new String(decodedBytes, "UTF-8");

        if ("JSON".equalsIgnoreCase(format)) {
            Gson gson = new Gson();
            return gson.fromJson(decodedString, Object.class); // Deserialize to generic Object
        } else if ("XML".equalsIgnoreCase(format)) {
            // Implement XML deserialization here if needed
            return null; // Placeholder
        } else {
            return null; // Or throw an exception for unsupported formats
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        // Test cases
        String jsonData = "{\"name\":\"John Doe\",\"age\":30}";
        String base64Json = Base64.getEncoder().encodeToString(jsonData.getBytes("UTF-8"));
        System.out.println(processRequest(base64Json, "JSON"));

        String xmlData = "<name>Jane Doe</name><age>25</age>";
        String base64Xml = Base64.getEncoder().encodeToString(xmlData.getBytes("UTF-8"));
        System.out.println(processRequest(base64Xml, "XML"));


        System.out.println(processRequest(base64Json, "json"));
        System.out.println(processRequest("", "json"));
        System.out.println(processRequest(null, "json"));



    }
}