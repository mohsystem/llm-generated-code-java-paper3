package ourMethod.gemini;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import org.json.JSONObject;
import org.json.JSONException;

public class Task63 {

    public static Object processRequest(String raw_data) throws UnsupportedEncodingException, JSONException {
        byte[] utf8Bytes = raw_data.getBytes("UTF-8"); 
        String base64Encoded = Base64.getEncoder().encodeToString(utf8Bytes);

        byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
        String decodedString = new String(decodedBytes, "UTF-8");
        
        JSONObject jsonData = new JSONObject(decodedString);
        return jsonData;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, JSONException {
        String[] testCases = {
            "{\"name\":\"John Doe\",\"age\":30}",
            "{\"city\":\"New York\",\"country\":\"USA\"}",
            "{\"items\":[{\"id\":1},{\"id\":2}]}",
            "{\"isValid\":true}",
            "{\"message\":\"Hello, world!\"}"
        };

        for (String testCase : testCases) {
            System.out.println("Test case: " + testCase);
            Object result = processRequest(testCase);
            System.out.println("Result: " + result);
            System.out.println();
        }
    }
}