package Vanilla.llama31;
import org.json.JSONObject;

public class Task62 {
    public static String getRootElement(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return jsonObject.keys().next().toString();
        } catch (Exception e) {
            return "Invalid JSON";
        }
    }

    public static void main(String[] args) {
        String[] testCases = {
            "{\"name\": \"Susan Smith\", \"org\": \"engineering\", \"projects\": [{\"name\":\"project1\", \"completed\":false}, {\"name\":\"project2\", \"completed\":true}]}",
            "{\"store\": {\"book\": [{\"category\": \"reference\", \"author\": \"Nigel Rees\", \"title\": \"Sayings of the Century\", \"price\": 8.95}]}",
            "{\"event\": {\"agency\": \"MI6\", \"data\": {\"name\": \"James Bond\", \"id\": \"007\"}}}",
            "{\"person\": {\"name\": \"John Doe\", \"age\": 30}}",
            "Invalid JSON"
        };

        for (String testCase : testCases) {
            System.out.println("Root Element: " + getRootElement(testCase));
        }
    }
}