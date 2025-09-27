package ourMethod.codestral;
import org.json.JSONObject;

public class Task62 {
    public static Object getRootElement(String jsonStr) {
        JSONObject jsonObj = new JSONObject(jsonStr);
        return jsonObj;
    }

    public static void main(String[] args) {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
        System.out.println(getRootElement(jsonStr));
    }
}