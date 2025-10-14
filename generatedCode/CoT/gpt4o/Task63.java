package CoT.openai;
import java.util.Base64;
import org.json.JSONObject;

public class Task63 {
    public static String processRequest(String rawData) {
        try {
            // Decode base64 encoded data
            byte[] decodedBytes = Base64.getDecoder().decode(rawData);
            String decodedData = new String(decodedBytes, "UTF-8");

            // Deserialize JSON
            JSONObject jsonObject = new JSONObject(decodedData);

            // Store deserialized data in a variable
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(processRequest("eyJrZXkiOiAidmFsdWUifQ==")); // {"key": "value"}
        System.out.println(processRequest("eyJmb28iOiAiYmFyIn0=")); // {"foo": "bar"}
        System.out.println(processRequest("eyJ4eHgiOiAieXl5In0=")); // {"xxx": "yyy"}
        System.out.println(processRequest("eyJhc2QiOiAiZnJvZyJ9")); // {"asd": "frog"}
        System.out.println(processRequest("eyJzdW5ueSI6ICJza3kifQ==")); // {"sunny": "sky"}
    }
}