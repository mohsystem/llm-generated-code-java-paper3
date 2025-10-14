package CoT.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Task64 {

    public static JSONObject fetchJsonFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            return new JSONObject(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a URL.");
            return;
        }

        String url = args[0];
        JSONObject jsonObject = fetchJsonFromUrl(url);

        if (jsonObject != null) {
            System.out.println(jsonObject.toString(4));
        } else {
            System.out.println("Failed to fetch JSON from the URL.");
        }
    }
}