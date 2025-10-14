package ourMethod.openai;
import java.util.Base64;
import org.json.JSONObject;

public class Task63 {

    public static String processRequest(String rawData) {
        try {
            // Step 1: Decode Base64
            byte[] decodedBytes = Base64.getDecoder().decode(rawData);
            String decodedData = new String(decodedBytes, "UTF-8");

            // Step 2: Deserialize JSON
            JSONObject jsonObject = new JSONObject(decodedData);

            // Step 3: Return the JSON object as a string
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"key\":\"value\"}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"name\":\"John\"}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"age\":30}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"city\":\"New York\"}".getBytes())));
        System.out.println(processRequest(Base64.getEncoder().encodeToString("{\"country\":\"USA\"}".getBytes())));
    }
}