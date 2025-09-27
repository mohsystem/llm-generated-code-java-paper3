package Vanilla.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class Task64 {
    public static JSONObject fetchJsonFromUrl(String urlStr) {
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return new JSONObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] urls = {
            "https://jsonplaceholder.typicode.com/todos/1",
            "https://api.github.com/users/github",
            "https://api.publicapis.org/entries",
            "https://api.ipify.org?format=json",
            "https://api.coindesk.com/v1/bpi/currentprice.json"
        };

        for (String url : urls) {
            System.out.println("Fetching JSON from: " + url);
            JSONObject json = fetchJsonFromUrl(url);
            if (json != null) {
                System.out.println("Response: " + json.toString());
            }
            System.out.println("------------------------");
        }
    }
}
