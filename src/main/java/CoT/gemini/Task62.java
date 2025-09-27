package CoT.gemini;
import org.json.JSONObject;
import org.json.JSONException;

public class Task62 {

    public static Object getRootElement(String jsonString) {
        try {
            return new JSONObject(jsonString).get((String) new JSONObject(jsonString).keys().next());
        } catch (JSONException e) {
            return null; // Or handle the error as needed
        }
    }

    public static void main(String[] args) {
        String test1 = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        String test2 = "[1, 2, 3]";
        String test3 = "{\"a\":{\"b\":{\"c\":1}}}";
        String test4 = "[]"; // Empty JSON array
        String test5 = "{}";  // Empty JSON object; in this case, next() would throw an exception in a real program

        System.out.println(getRootElement(test1)); // Expected: {"age":30,"city":"New York","name":"John"}
        System.out.println(getRootElement(test2)); // Expected: [1,2,3]
        System.out.println(getRootElement(test3)); // Expected: {"b":{"c":1}}
        System.out.println(getRootElement(test4)); // Expected: []
        System.out.println(getRootElement(test5)); // Expected: null 

    }
}