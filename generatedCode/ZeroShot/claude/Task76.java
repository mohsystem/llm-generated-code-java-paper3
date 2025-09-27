package ZeroShot.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Task76 {
    public static String getPageTitle(String urlStr) {
        String title = "";
        HttpsURLConnection conn = null;
        BufferedReader reader = null;
        
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            
            URL url = new URL(urlStr);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                int titleStart = line.toLowerCase().indexOf("<title>");
                if (titleStart != -1) {
                    int titleEnd = line.toLowerCase().indexOf("</title>");
                    if (titleEnd != -1) {
                        title = line.substring(titleStart + 7, titleEnd).trim();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            title = "Error: " + e.getMessage();
        } finally {
            try {
                if (reader != null) reader.close();
                if (conn != null) conn.disconnect();
            } catch (Exception e) {
                // Handle silently
            }
        }
        return title;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://www.example.com",
            "https://www.google.com",
            "https://www.github.com",
            "https://www.wikipedia.org",
            "https://www.microsoft.com"
        };

        for (String url : testUrls) {
            System.out.println("URL: " + url);
            System.out.println("Title: " + getPageTitle(url));
            System.out.println();
        }
    }
}
