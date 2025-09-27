package CoT.llama31;
import java.io.BufferedReader;
import java.io.IOException;
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
        try {
            String jsonContent = readUrlContent(url);
            JSONObject jsonObject = new JSONObject(jsonContent);
            System.out.println(jsonObject.toString(4));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String readUrlContent(String url) throws IOException {
        URL urlObject = new URL(url);
        URLConnection connection = urlObject.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        return content.toString();
    }
}