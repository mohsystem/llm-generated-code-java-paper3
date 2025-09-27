package ZeroShot.codestral;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Task62 {
    public static String getRootElement(String jsonString) {
        JsonElement jsonElement = JsonParser.parseString(jsonString);
        return jsonElement.getAsJsonObject().keySet().iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(getRootElement("{\"root\": {\"child1\": \"value1\", \"child2\": \"value2\"}}"));
        System.out.println(getRootElement("{\"anotherRoot\": {\"child\": \"value\"}}"));
        System.out.println(getRootElement("{\"rootElement\": {\"nested\": {\"deeply\": \"nestedValue\"}}}"));
        System.out.println(getRootElement("{\"singleRoot\": \"singleValue\"}"));
        System.out.println(getRootElement("{\"emptyRoot\": {}}"));
    }
}