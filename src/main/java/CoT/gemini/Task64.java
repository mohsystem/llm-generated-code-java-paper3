package CoT.gemini;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Task64 {

    public static JSONObject readJsonFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return new JSONObject(new JSONTokener(response.toString()));


        }
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Please provide a URL as a command-line argument.");
                return;
            }
            String url = args[0];
            JSONObject jsonObject = readJsonFromUrl(url);
            System.out.println(jsonObject.toString(2)); // Use toString(2) for pretty printing


        } catch (IOException e) {
            System.err.println("Error reading or parsing JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}