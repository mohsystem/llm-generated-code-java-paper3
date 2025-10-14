package ourMethod.openai;
import org.json.JSONObject;

public class Task62 {
    public static String getRootElement(String jsonString) {
        if (jsonString == null || jsonString.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }
        JSONObject jsonObject = new JSONObject(jsonString);
        if (jsonObject.keys().hasNext()) {
            return jsonObject.keys().next();
        }
        return null;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getRootElement("{\"root\": {\"key\": \"value\"}}")); // Output: root
        System.out.println(getRootElement("{\"anotherRoot\": {\"key\": \"value\"}}")); // Output: anotherRoot
        System.out.println(getRootElement("{\"nested\": {\"inside\": {\"key\": \"value\"}}}")); // Output: nested
        System.out.println(getRootElement("{\"empty\": {}}")); // Output: empty
        System.out.println(getRootElement("{\"onlyKey\": \"onlyValue\"}")); // Output: onlyKey
    }
}