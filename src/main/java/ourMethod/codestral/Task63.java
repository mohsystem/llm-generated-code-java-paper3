package ourMethod.codestral;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Task63 {
    public static Object processRequest(String rawData) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(rawData);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(decodedString, Object.class);
    }

    public static void main(String[] args) throws IOException {
        String testData = Base64.getEncoder().encodeToString("{\"key\": \"value\"}".getBytes(StandardCharsets.UTF_8));
        System.out.println(processRequest(testData));
    }
}