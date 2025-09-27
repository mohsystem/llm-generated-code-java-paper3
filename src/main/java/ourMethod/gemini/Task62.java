package ourMethod.gemini;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class Task62 {

    public static Object getRootElement(String jsonString) {
        try {
            if (jsonString == null || jsonString.trim().isEmpty()) {
                return null; 
            }

            jsonString = jsonString.trim();

            if (jsonString.startsWith("{")) {
                return new JSONObject(jsonString);
            } else if (jsonString.startsWith("[")) {
                return new JSONArray(jsonString);
            } else {
                return null;
            }
        } catch (JSONException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String[] testCases = {
                "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}",
                "[1, 2, 3]",
                "{\"a\":{\"b\":{\"c\":\"d\"}}}",
                "{\"employees\":[{\"firstName\":\"John\", \"lastName\":\"Doe\"},{\"firstName\":\"Anna\", \"lastName\":\"Smith\"},{\"firstName\":\"Peter\", \"lastName\":\"Jones\"}]}",
                 "   "

        };


        for (String testCase : testCases) {
            Object root = getRootElement(testCase);
            System.out.println("Input: " + testCase);
            System.out.println("Root Element: " + root);

        }
    }
}