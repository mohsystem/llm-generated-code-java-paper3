package Vanilla.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Task64 {

    public static JSONObject fetchJsonFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return new JSONObject(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a URL as a command line argument.");
            return;
        }
        String url = args[0];
        JSONObject json = fetchJsonFromUrl(url);
        System.out.println(json != null ? json.toString() : "Failed to fetch JSON.");

        // Example test cases
        // System.out.println(fetchJsonFromUrl("https://api.example.com/data1").toString());
        // System.out.println(fetchJsonFromUrl("https://api.example.com/data2").toString());
        // System.out.println(fetchJsonFromUrl("https://api.example.com/data3").toString());
        // System.out.println(fetchJsonFromUrl("https://api.example.com/data4").toString());
        // System.out.println(fetchJsonFromUrl("https://api.example.com/data5").toString());
    }
}