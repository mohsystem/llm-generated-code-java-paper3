package CoT.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task160 {
    public static String fetchURL(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            conn.disconnect();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(fetchURL("http://example.com"));
            System.out.println(fetchURL("http://example.org"));
            System.out.println(fetchURL("http://example.net"));
            System.out.println(fetchURL("http://example.edu"));
            System.out.println(fetchURL("http://example.gov"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}