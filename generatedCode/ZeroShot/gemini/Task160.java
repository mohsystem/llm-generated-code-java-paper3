package ZeroShot.gemini;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;


public class Task160 {

    public static String makeHttpRequest(String urlString) throws IOException {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "HTTP request failed with response code: " + responseCode;

            }

        } catch (MalformedURLException e) {
            return "Invalid URL format";
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(makeHttpRequest("https://www.example.com"));
            System.out.println(makeHttpRequest("https://www.google.com"));
            System.out.println(makeHttpRequest("https://www.amazon.com"));
            System.out.println(makeHttpRequest("https://www.wikipedia.org"));
            System.out.println(makeHttpRequest("invalidurl"));
        }
        catch (IOException e){
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
}