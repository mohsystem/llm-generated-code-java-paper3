package ZeroShot.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Task64 {

    public static JSONObject fetchJsonFromUrl(String urlString) {
        JSONObject jsonObject = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();
            jsonObject = new JSONObject(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Task64 <URL>");
            return;
        }
        String url = args[0];
        JSONObject json = fetchJsonFromUrl(url);
        System.out.println(json);
    }
}