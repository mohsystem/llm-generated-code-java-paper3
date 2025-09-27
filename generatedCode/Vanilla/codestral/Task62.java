package Vanilla.codestral;
import org.json.JSONObject;

public class Task62 {
    public static String extractRootElement(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.keys().next();
    }

    public static void main(String[] args) {
        String[] testCases = {"{\"key1\": \"value1\"}", "{\"key2\": {\"key3\": \"value3\"}}", "{\"key4\": [1, 2, 3]}", "{\"key5\": null}", "{\"key6\": true}"};
        for (String testCase : testCases) {
            System.out.println("Root element of " + testCase + " is: " + extractRootElement(testCase));
        }
    }
}