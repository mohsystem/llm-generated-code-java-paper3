package ZeroShot.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static String makeHttpRequest(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            BufferedReader reader;
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            return content.toString();
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(makeHttpRequest("http://www.example.com"));
        System.out.println(makeHttpRequest("https://www.google.com"));
        System.out.println(makeHttpRequest("https://www.nonexistenturl.com"));
        System.out.println(makeHttpRequest("https://www.github.com"));
        System.out.println(makeHttpRequest("http://invalid-url"));
    }
}