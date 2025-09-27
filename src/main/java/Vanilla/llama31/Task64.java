package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class Task64 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the URL as a command line argument.");
            return;
        }
        String url = args[0];
        JSONObject jsonObject = readAndParseJson(url);
        if (jsonObject != null) {
            System.out.println(jsonObject.toString(4));
        }
    }

    public static JSONObject readAndParseJson(String url) {
        try {
            URL jsonUrl = new URL(url);
            URLConnection connection = jsonUrl.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
            return new JSONObject(json.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}