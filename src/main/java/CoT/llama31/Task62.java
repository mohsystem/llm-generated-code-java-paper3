package CoT.llama31;
import org.json.JSONObject;

public class Task62 {
    public static void main(String[] args) {
        String[] testCases = {
            "{\"name\": \"John Doe\", \"age\": 30, \"email\": \"john.doe@example.com\"}",
            "{\"city\": \"New York\", \"country\": \"USA\"}",
            "{\"students\": [{\"name\": \"Alice\", \"age\": 20}, {\"name\": \"Bob\", \"age\": 21}]}",
            "{\"empty\": {}}",
            "{\"null\": null}"
        };

        for (String testCase : testCases) {
            JSONObject jsonObject = new JSONObject(testCase);
            System.out.println("Root Element: " + jsonObject.names().getString(0));
        }
    }
}