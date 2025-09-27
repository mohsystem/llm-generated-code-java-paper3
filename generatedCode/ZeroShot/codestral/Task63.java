package ZeroShot.codestral;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;

public class Task63 {
    public static Object processRequest(String rawData) {
        byte[] decodedBytes = Base64.getDecoder().decode(rawData);
        String decodedData = new String(decodedBytes, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        return gson.fromJson(decodedData, Object.class);
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "eyJuYW1lIjoiSm9obiIsImVtYWlsIjoiSm9obi5Kb2huQGVtYWlsLmNvbSJ9";
        String test2 = "eyJuYW1lIjoiTWFya2VyIiwiZW1haWwiOiJNYXJrZXJAZW1haWwuY29tIn0=";
        String test3 = "eyJuYW1lIjoiQXJpYW4iLCJlbWFpbCI6IkFyaWFuQGVtYWlsLmNvbSJ9";
        String test4 = "eyJuYW1lIjoiTW9yayIsImVtYWlsIjoiTW9yay5Nb3JrQGVtYWlsLmNvbSJ9";
        String test5 = "eyJuYW1lIjoiQ2hyaXN0YW4iLCJlbWFpbCI6IkNoaXN0YW5AZW1haWwuY29tIn0=";

        System.out.println(processRequest(test1));
        System.out.println(processRequest(test2));
        System.out.println(processRequest(test3));
        System.out.println(processRequest(test4));
        System.out.println(processRequest(test5));
    }
}