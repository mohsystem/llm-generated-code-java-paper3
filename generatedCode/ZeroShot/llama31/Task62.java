package ZeroShot.llama31;
// Task62.java
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task62 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String[] testCases = {
            "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}",
            "{\"id\":1, \"name\":\"Jane\", \" occupation\":\"Developer\"}",
            "{\"company\":{\"name\":\"ABC Inc\", \"address\":{\"street\":\"123 Main St\", \"city\":\"Anytown\"}}}",
            "{\"empty\":{}}",
            "{\"null\":null}"
        };

        for (String testCase : testCases) {
            JsonNode root = mapper.readTree(testCase);
            System.out.println("Root Element: " + root);
        }
    }
}