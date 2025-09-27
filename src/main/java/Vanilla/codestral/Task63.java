package Vanilla.codestral;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;

public class Task63 {
    public static <T> T processRequest(String rawData, Class<T> clazz) {
        byte[] decodedBytes = Base64.getDecoder().decode(rawData);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        T deserializedData = new Gson().fromJson(decodedString, clazz);
        return deserializedData;
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "eyJuYW1lIjoiSm9obiIsImVtYWlsIjoiam9obi5kb2VAZXhhbXBsZS5jb20ifQ==";
        System.out.println(processRequest(test1, MyClass.class));
    }

    static class MyClass {
        String name;
        String email;

        @Override
        public String toString() {
            return "Name: " + name + ", Email: " + email;
        }
    }
}