package ZeroShot.codestral;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Task131 {
    public static Object deserialize(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Object.class);
    }

    public static void main(String[] args) throws IOException {
        String[] testCases = {"{\"key\": \"value\"}", "{\"array\": [1, 2, 3]}", "{}", "null", "{\"object\": {\"key\": \"value\"}}"};
        for (String json : testCases) {
            System.out.println(deserialize(json));
        }
    }
}