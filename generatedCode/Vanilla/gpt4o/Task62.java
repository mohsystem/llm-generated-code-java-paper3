package Vanilla.openai;
import org.json.JSONObject;

public class Task62 {
    public static String getRootElement(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.keys().next();
    }

    public static void main(String[] args) {
        System.out.println(getRootElement("{\"name\": \"John\", \"age\": 30}"));
        System.out.println(getRootElement("{\"city\": \"New York\", \"country\": \"USA\"}"));
        System.out.println(getRootElement("{\"fruit\": \"Apple\", \"color\": \"Red\"}"));
        System.out.println(getRootElement("{\"car\": \"Toyota\", \"year\": 2020}"));
        System.out.println(getRootElement("{\"language\": \"Java\", \"version\": 11}"));
    }
}