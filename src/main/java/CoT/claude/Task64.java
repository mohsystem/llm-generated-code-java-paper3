package CoT.claude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

public class Task64 {
    public static JSONObject fetchJsonFromUrl(String urlStr) throws Exception {
        // Input validation
        if (urlStr == null || urlStr.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        // Validate URL format
        URL url = new URL(urlStr);
        
        // Configure SSL context for HTTPS
        SSLContext sslContext = SSLContext.getInstance("TLS");
        TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            if (conn instanceof HttpsURLConnection) {
                ((HttpsURLConnection) conn).setSSLSocketFactory(sslContext.getSocketFactory());
            }
            
            // Set connection timeout and read timeout
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            
            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            
            return new JSONObject(response.toString());
            
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        String[] testUrls = {
            "https://api.github.com/users/github",
            "https://api.publicapis.org/entries",
            "https://jsonplaceholder.typicode.com/posts/1",
            "https://api.openweathermap.org/data/2.5/weather?q=London&appid=YOUR_API_KEY",
            "https://api.coincap.io/v2/assets/bitcoin"
        };

        for (String url : testUrls) {
            try {
                JSONObject json = fetchJsonFromUrl(url);
                System.out.println("Successfully fetched JSON from: " + url);
                System.out.println(json.toString(2));
            } catch (Exception e) {
                System.err.println("Error fetching JSON from " + url + ": " + e.getMessage());
            }
            System.out.println("------------------------");
        }
    }
}
