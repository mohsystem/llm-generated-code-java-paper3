package ourMethodv2.gpt4o;
import java.util.Base64;
import org.json.JSONObject;

public class Task63 {
    public static Object processRequest(String rawData) {
        // Decode Base64 encoded data
        byte[] decodedBytes = Base64.getDecoder().decode(rawData);
        String decodedString = new String(decodedBytes, java.nio.charset.StandardCharsets.UTF_8);
        
        // Deserialize JSON data
        JSONObject jsonObject = new JSONObject(decodedString);
        
        // Store and return the deserialized data
        return jsonObject.toMap();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"key\":\"value\"}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"name\":\"John\",\"age\":30}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"city\":\"New York\"}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"list\":[1,2,3]}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"boolean\":true}".getBytes())));
    }
}