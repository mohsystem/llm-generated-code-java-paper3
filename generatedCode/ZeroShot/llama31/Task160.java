package ZeroShot.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static void main(String[] args) throws IOException {
        String[] testUrls = {
            "http://example.com",
            "https://www.google.com",
            "http://localhost:8080/test.html",
            "https://www.github.com",
            "http://invalid-url"
        };

        for (String url : testUrls) {
            makeHttpRequest(url);
        }
    }

    public static void makeHttpRequest(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("URL: " + url + ", Response Code: " + responseCode);

        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        }
    }
}