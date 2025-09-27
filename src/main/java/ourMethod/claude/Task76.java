package ourMethod.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static String getPageTitle(String urlStr) throws Exception {
        if (urlStr == null || !urlStr.toLowerCase().startsWith("https://")) {
            throw new IllegalArgumentException("Invalid URL: URL must start with https://");
        }

        URL url = new URL(urlStr);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        
        try {
            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new Exception("HTTP request failed with response code: " + responseCode);
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder content = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            
            Pattern pattern = Pattern.compile("<title>(.*?)</title>");
            Matcher matcher = pattern.matcher(content.toString());
            
            if (matcher.find()) {
                return matcher.group(1).trim();
            } else {
                return "No title found";
            }
        } finally {
            conn.disconnect();
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java Task76 <https_url>");
                return;
            }
            
            String url = args[0];
            String title = getPageTitle(url);
            System.out.println("Page title: " + title);
            
            // Test cases
            String[] testUrls = {
                "https://www.example.com",
                "https://www.google.com",
                "https://www.github.com", 
                "https://www.oracle.com",
                "https://www.microsoft.com"
            };
            
            for(String testUrl : testUrls) {
                System.out.println("\\nTesting URL: " + testUrl);
                System.out.println("Title: " + getPageTitle(testUrl));
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
