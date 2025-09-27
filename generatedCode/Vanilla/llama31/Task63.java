package Vanilla.llama31;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class Task63 {
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIjoiMjMwfQ==",
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIjoiMjMwfQ==",
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIjoiMjMwfQ==",
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIjoiMjMwfQ==",
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIjoiMjMwfQ=="
        };

        for (String testCase : testCases) {
            processRequest(testCase);
        }
    }

    public static void processRequest(String raw_data) {
        // Decode the raw_data using Base64
        byte[] decodedBytes = Base64.getDecoder().decode(raw_data);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);

        // Deserialize the decoded data into its original format (e.g., JSON)
        JSONObject deserializedData = new JSONObject(decodedString);
        System.out.println(deserializedData);
    }
}