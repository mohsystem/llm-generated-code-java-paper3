package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class Task64 {
    public static JSONObject readJsonFromUrl(String url) throws Exception {
        URL jsonUrl = new URL(url);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(jsonUrl.openStream()))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            return new JSONObject(jsonContent.toString());
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(readJsonFromUrl("https://example.com/test.json"));
            System.out.println(readJsonFromUrl("https://example.com/test2.json"));
            System.out.println(readJsonFromUrl("https://example.com/test3.json"));
            System.out.println(readJsonFromUrl("https://example.com/test4.json"));
            System.out.println(readJsonFromUrl("https://example.com/test5.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}