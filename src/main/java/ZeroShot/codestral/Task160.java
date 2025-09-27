package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Task160 {
    public static String fetchUrl(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        StringBuilder response = new StringBuilder();

        while ((output = br.readLine()) != null) {
            response.append(output);
        }

        conn.disconnect();
        return response.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(fetchUrl("http://example.com"));
            System.out.println(fetchUrl("http://google.com"));
            System.out.println(fetchUrl("http://github.com"));
            System.out.println(fetchUrl("http://stackoverflow.com"));
            System.out.println(fetchUrl("http://invalid-url.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}