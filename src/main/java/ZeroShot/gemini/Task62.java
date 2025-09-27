package ZeroShot.gemini;
import org.json.JSONObject;
import org.json.JSONException;

class Task62 {
    public static String getRootElement(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            return json.names().getString(0);

        } catch (JSONException e) {
            return null; // Or handle the error as needed
        }
    }

    public static void main(String[] args) {
        String test1 = "{\"name\": \"John\", \"age\": 30}";
        String test2 = "[{\"name\": \"John\"}, {\"name\": \"Jane\"}]";
        String test3 = "123";
        String test4 = "\"hello\"";
        String test5 = "{}";


        System.out.println("Test 1: " + getRootElement(test1)); // Output: name
        System.out.println("Test 2: " + getRootElement(test2)); // Output: null
        System.out.println("Test 3: " + getRootElement(test3)); // Output: null
        System.out.println("Test 4: " + getRootElement(test4)); // Output: null
        System.out.println("Test 5: " + getRootElement(test5)); // Output: null


    }
}