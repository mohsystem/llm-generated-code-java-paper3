package Vanilla.gemini;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class Task63 {

    public static Object processData(String raw_data) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(raw_data);
            String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            return gson.fromJson(decodedString, Object.class);
        } catch (IllegalArgumentException | JsonSyntaxException e) {
            return null; // Or handle the error as needed
        }
    }

    public static void main(String[] args) {
        String test1 = Base64.getEncoder().encodeToString("{\"key\": \"value\"}".getBytes(StandardCharsets.UTF_8));
        System.out.println(processData(test1));

        String test2 = Base64.getEncoder().encodeToString("[1, 2, 3]".getBytes(StandardCharsets.UTF_8));
        System.out.println(processData(test2));

        String test3 = Base64.getEncoder().encodeToString("{\"a\": 1, \"b\": \"2\"}".getBytes(StandardCharsets.UTF_8));
        System.out.println(processData(test3));

        String test4 = "invalid base64 string";
        System.out.println(processData(test4));

        String test5 = Base64.getEncoder().encodeToString("{invalid json}".getBytes(StandardCharsets.UTF_8));
        System.out.println(processData(test5));
    }
}