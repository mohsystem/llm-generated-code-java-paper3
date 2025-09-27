package ZeroShot.llama31;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONObject;

public class Task64 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the URL as a command line argument.");
            return;
        }
        String url = args[0];
        JSONObject jsonObject = readAndParseJsonFromUrl(url);
        if (jsonObject != null) {
            System.out.println(jsonObject.toString(4));
        } else {
            System.out.println("Failed to read or parse JSON.");
        }
    }

    public static JSONObject readAndParseJsonFromUrl(String url) {
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();
            return new JSONObject(jsonBuilder.toString());
        } catch (Exception e) {
            System.out.println("Error reading or parsing JSON: " + e.getMessage());
            return null;
        }
    }
}