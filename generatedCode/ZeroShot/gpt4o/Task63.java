package ZeroShot.gpt4o;
import java.util.Base64;
import org.json.JSONObject;
import org.json.XML;

public class Task63 {

    public static String processRequest(String raw_data) {
        try {
            // Step 1: Ensure UTF-8 Encoding
            byte[] utf8EncodedData = raw_data.getBytes("UTF-8");

            // Step 2: Decode using Base64
            byte[] decodedBytes = Base64.getDecoder().decode(utf8EncodedData);

            // Step 3: Deserialize JSON
            String jsonString = new String(decodedBytes, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonString);

            // Alternatively, if XML:
            // JSONObject jsonObject = XML.toJSONObject(jsonString);

            // Step 4: Store and Return
            return jsonObject.toString();
        } catch (Exception e) {
            // Handle exceptions securely
            return "{}";
        }
    }

    public static void main(String[] args) {
        System.out.println(processRequest("eyJrZXkiOiAiVmFsdWUifQ==")); // {"key": "Value"}
        System.out.println(processRequest("eyJhZ2UiOiAzMH0=")); // {"age": 30}
        System.out.println(processRequest("eyJjYWxsIjogIk1lIn0=")); // {"call": "Me"}
        System.out.println(processRequest("eyJuYW1lIjogIkpvZSJ9")); // {"name": "Joe"}
        System.out.println(processRequest("eyJhZGRyZXNzIjogIlN0cmVldCJ9")); // {"address": "Street"}
    }
}