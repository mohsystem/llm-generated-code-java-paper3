package Vanilla.llama31;
import org.json.JSONObject;

public class Task131 {
    public static void main(String[] args) {
        String[] testCases = {
            "{\"name\":\"John\",\"age\":30}",
            "{\"name\":\"Alice\",\"age\":25}",
            "{\"name\":\"Bob\",\"age\":40}",
            "{\"name\":\"Charlie\",\"age\":35}",
            "{\"name\":\"David\",\"age\":20}"
        };

        for (String testCase : testCases) {
            deserializeJson(testCase);
        }
    }

    public static void deserializeJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            System.out.println("Name: " + jsonObject.getString("name"));
            System.out.println("Age: " + jsonObject.getInt("age"));
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}