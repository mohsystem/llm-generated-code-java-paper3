package CoT.llama31;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static void main(String[] args) {
        String[] urls = {
            "http://example.com",
            "http://www.google.com",
            "http://www.apache.org",
            "http://www.python.org",
            "http://www.github.com"
        };

        for (String url : urls) {
            System.out.println("Making request to: " + url);
            makeHttpRequest(url);
        }
    }

    public static void makeHttpRequest(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}