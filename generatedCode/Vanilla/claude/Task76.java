package Vanilla.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class Task76 {
    public static String extractTitle(String urlStr) {
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                int titleStartIndex = line.toLowerCase().indexOf("<title>");
                if (titleStartIndex != -1) {
                    int titleEndIndex = line.toLowerCase().indexOf("</title>");
                    if (titleEndIndex != -1) {
                        return line.substring(titleStartIndex + 7, titleEndIndex).trim();
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return "Title not found";
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://www.google.com",
            "https://www.github.com",
            "https://www.wikipedia.org",
            "https://www.microsoft.com",
            "https://www.amazon.com"
        };

        for (String url : testUrls) {
            System.out.println("URL: " + url);
            System.out.println("Title: " + extractTitle(url));
            System.out.println();
        }
    }
}
