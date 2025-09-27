package Vanilla.gemini;
import org.json.JSONObject;
import org.json.JSONException;

class Task62 {
    public static String getRootElement(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return jsonObject.names().getString(0);
        } catch (JSONException e) {
            return null; // Or handle the error as needed
        }
    }

    public static void main(String[] args) {
        String test1 = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
        String test2 = "[{\"name\":\"John\", \"age\":30},{\"name\":\"Jane\", \"age\":25}]";
        String test3 = "[]"; // Empty Array, no root
        String test4 = "{}"; // Empty Object, no root
        String test5 = "\"Just a string\"";


        System.out.println(getRootElement(test1)); // Output: name
        System.out.println(getRootElement(test2)); // Output: null (because it's an array)
        System.out.println(getRootElement(test3)); // Output: null
        System.out.println(getRootElement(test4)); // Output: null
        System.out.println(getRootElement(test5)); // Output: null

    }
}