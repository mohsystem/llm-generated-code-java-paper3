package ZeroShot.codestral;
import javax.net.ssl.*;
import java.io.*;
import java.net.URL;

public class Task105 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.example.com");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response : " + response.toString());
    }
}