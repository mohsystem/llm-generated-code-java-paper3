package Vanilla.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static String httpRequest(String urlStr) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (Exception e) {
            return e.getMessage();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(httpRequest("http://www.example.com"));
        System.out.println(httpRequest("http://www.google.com"));
        System.out.println(httpRequest("http://www.github.com"));
        System.out.println(httpRequest("http://www.stackoverflow.com"));
        System.out.println(httpRequest("http://www.wikipedia.org"));
    }
}