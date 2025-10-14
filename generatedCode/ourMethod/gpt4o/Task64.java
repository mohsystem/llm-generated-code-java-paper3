package ourMethod.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public class Task64 {

    public static JSONObject fetchJSONFromURL(String urlString) {
        Callable<JSONObject> fetchTask = () -> {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // Set timeout to 5 seconds
            conn.setReadTimeout(5000); // Set read timeout to 5 seconds
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
            }
            return new JSONObject(result.toString());
        };

        Future<JSONObject> future = Executors.newSingleThreadExecutor().submit(fetchTask);
        try {
            return future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException("Failed to fetch JSON", e);
        } finally {
            future.cancel(true);
        }
    }

    public static void main(String[] args) {
        String[] testURLs = {
            "https://example.com/json1",
            "https://example.com/json2",
            "https://example.com/json3",
            "https://example.com/json4",
            "https://example.com/json5"
        };
        
        for (String url : testURLs) {
            try {
                JSONObject jsonObject = fetchJSONFromURL(url);
                System.out.println("Fetched JSON from: " + url);
                System.out.println(jsonObject.toString(4)); // Pretty print JSON
            } catch (RuntimeException e) {
                System.err.println("Error fetching JSON from " + url + ": " + e.getMessage());
            }
        }
    }
}