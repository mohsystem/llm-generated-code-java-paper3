package CoT.llama31;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import org.json.JSONObject;

public class Task63 {
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "SGVsbG8gd29ybGQh", // Base64 encoded "Hello world!"
            "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz48cmVxdWlyZWRfdGltZT4yMDI0LTA5LTI4PC9yZXF1aXJlZF90aW1lPjwvY2F0Pj4=", // Base64 encoded XML
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIj9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIn0=", // Base64 encoded JSON
            "", // Empty string
            null // Null input
        };

        for (String testCase : testCases) {
            System.out.println(processRequest(testCase));
        }
    }

    public static String processRequest(String raw_data) {
        if (raw_data == null || raw_data.isEmpty()) {
            return "Invalid input";
        }

        try {
            // Decode the raw_data using Base64
            byte[] decodedBytes = Base64.getDecoder().decode(raw_data);
            String decodedData = new String(decodedBytes, StandardCharsets.UTF_8);

            // Deserialize the decoded data into its original format
            if (decodedData.startsWith("<")) { // XML
                return "XML: " + decodedData;
            } else if (decodedData.startsWith("{")) { // JSON
                JSONObject jsonObject = new JSONObject(decodedData);
                return "JSON: " + jsonObject.toString();
            } else {
                return "Unknown format: " + decodedData;
            }
        } catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }
}