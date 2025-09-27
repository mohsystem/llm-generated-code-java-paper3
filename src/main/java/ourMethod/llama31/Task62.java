package ourMethod.llama31;

import org.json.JSONObject;

public class Task62 {
    public static void main(String[] args) {
        String[] testCases = {
            "{\"key\":\"value\"}",
            "{\"array\":[1,2,3]}",
            "{\"object\":{\"nestedKey\":\"nestedValue\"}}"
        };
        for (String testCase : testCases) {
            JSONObject jsonObject = new JSONObject(testCase);
            System.out.println("Root Element: " + jsonObject);
        }
    }
}