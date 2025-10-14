package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class Task64 {

    public static JSONObject fetchJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return new JSONObject(content.toString());
        }
    }

    public static void main(String[] args) {
        try {
            String[] testUrls = {
                "https://jsonplaceholder.typicode.com/todos/1",
                "https://jsonplaceholder.typicode.com/posts/1",
                "https://jsonplaceholder.typicode.com/users/1",
                "https://jsonplaceholder.typicode.com/comments/1",
                "https://jsonplaceholder.typicode.com/albums/1"
            };
            for (String url : testUrls) {
                JSONObject jsonObject = fetchJsonFromUrl(url);
                System.out.println(jsonObject.toString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}