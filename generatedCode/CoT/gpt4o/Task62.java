package CoT.openai;
import org.json.JSONObject;

public class Task62 {

    public static String getRootElement(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.keys().next();
    }

    public static void main(String[] args) {
        System.out.println(getRootElement("{\"key1\": \"value1\"}"));
        System.out.println(getRootElement("{\"key2\": {\"subkey\": \"value\"}}"));
        System.out.println(getRootElement("{\"key3\": [1, 2, 3]}"));
        System.out.println(getRootElement("{\"key4\": \"value4\", \"key5\": \"value5\"}"));
        System.out.println(getRootElement("{\"key6\": {\"subkey\": {\"subsubkey\": \"value\"}}}"));
    }
}