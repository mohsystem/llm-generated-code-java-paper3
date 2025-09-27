package CoT.codestral;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;

public class Task63 {
    public static <T> T processRequest(String rawData, Class<T> clazz) {
        byte[] decodedBytes = Base64.getDecoder().decode(rawData);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        return gson.fromJson(decodedString, clazz);
    }

    public static void main(String[] args) {
        // Test cases
        String testData1 = "eyJuYW1lIjoiSm9obiIsImVtYWlsIjoiSm9obi5Kb2huQGVtYWlsLmNvbSJ9";
        System.out.println(processRequest(testData1, MyClass.class));
        // Add more test cases as needed
    }

    static class MyClass {
        private String name;
        private String email;

        // Getters and setters
    }
}