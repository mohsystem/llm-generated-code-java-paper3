package ourMethodv2.gpt4o;
import org.json.JSONObject;

public class Task62 {
    public static String getRootElement(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.keys().next();
    }

    public static void main(String[] args) {
        System.out.println(getRootElement("{\"key1\": \"value1\", \"key2\": \"value2\"}")); // Output: key1
        System.out.println(getRootElement("{\"name\": \"John\", \"age\": 30}")); // Output: name
        System.out.println(getRootElement("{\"city\": \"New York\", \"state\": \"NY\"}")); // Output: city
        System.out.println(getRootElement("{\"fruit\": \"Apple\", \"color\": \"Red\"}")); // Output: fruit
        System.out.println(getRootElement("{\"animal\": \"Dog\", \"breed\": \"Labrador\"}")); // Output: animal
    }
}