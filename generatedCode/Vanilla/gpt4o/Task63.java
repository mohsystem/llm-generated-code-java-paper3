package Vanilla.openai;
import java.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class Task63 {

    public static Map<String, Object> processRequest(String rawData) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(rawData.getBytes("UTF-8"));
        String jsonString = new String(decodedBytes, "UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializedData = objectMapper.readValue(jsonString, Map.class);

        return deserializedData;
    }

    public static void main(String[] args) throws Exception {
        String[] testCases = {
            "eyJrZXkiOiAidmFsdWUifQ==", 
            "eyJ0ZXN0IjogInRlc3QxIn0=", 
            "eyJleGFtcGxlIjogImV4YW1wbGUifQ==", 
            "eyJmb28iOiAiYmFyIn0=", 
            "eyJkYXRhIjogInNhbXBsZSJ9"
        };

        for (String testCase : testCases) {
            System.out.println(processRequest(testCase));
        }
    }
}