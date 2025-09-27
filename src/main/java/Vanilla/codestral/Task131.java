package Vanilla.codestral;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public class Task131 {
    public static <T> T deserialize(String json, Type typeOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeOfT);
    }

    public static void main(String[] args) {
        // Test cases
        String json1 = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
        User user1 = deserialize(json1, User.class);
        System.out.println(user1.name + " " + user1.age + " " + user1.city);

        // More test cases here...
    }

    static class User {
        String name;
        int age;
        String city;
    }
}