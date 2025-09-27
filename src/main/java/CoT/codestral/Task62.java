package CoT.codestral;
import org.json.JSONObject;

public class Task62 {
    public static String getRootElement(String jsonStr) {
        JSONObject json = new JSONObject(jsonStr);
        return (String) json.keys().next();
    }

    public static void main(String[] args) {
        String jsonStr = "{\"rootElement\": {\"key\": \"value\"}}";
        System.out.println(getRootElement(jsonStr));
    }
}