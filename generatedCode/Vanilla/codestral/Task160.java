package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static String getURLContent(String urlStr) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
           result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(getURLContent("http://www.example.com"));
            System.out.println(getURLContent("http://www.google.com"));
            System.out.println(getURLContent("http://www.yahoo.com"));
            System.out.println(getURLContent("http://www.facebook.com"));
            System.out.println(getURLContent("http://www.github.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}