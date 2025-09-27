package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class Task64 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task64 <URL>");
            return;
        }
        String url = args[0];
        try {
            String jsonContent = fetchJsonFromUrl(url);
            JSONObject jsonObject = new JSONObject(jsonContent);
            System.out.println(jsonObject.toString(4));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String fetchJsonFromUrl(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }
}