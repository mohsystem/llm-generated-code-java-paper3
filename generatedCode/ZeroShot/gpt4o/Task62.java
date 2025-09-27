package ZeroShot.gpt4o;
import org.json.JSONObject;

public class Task62 {
    public static String findRootElement(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.keys().next();
    }

    public static void main(String[] args) {
        System.out.println(findRootElement("{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}"));
        System.out.println(findRootElement("{\"employee\":{\"name\":\"Anna\",\"age\":28,\"city\":\"London\"}}"));
        System.out.println(findRootElement("{\"menu\":{\"id\":\"file\",\"value\":\"File\"}}"));
        System.out.println(findRootElement("{\"widget\":{\"debug\":\"on\",\"window\":{\"title\":\"Sample Widget\"}}}"));
        System.out.println(findRootElement("{\"library\":{\"books\":[],\"staff\":{}}}"));
    }
}