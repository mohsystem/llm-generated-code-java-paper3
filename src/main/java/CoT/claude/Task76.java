package CoT.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static String getPageTitle(String urlStr) {
        String title = "";
        try {
            // Configure SSL context to validate certificates
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            
            // Set timeout to prevent hanging
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();
            
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            // Extract title using regex
            Pattern pattern = Pattern.compile("<title>(.*?)</title>");
            Matcher matcher = pattern.matcher(content.toString());
            if (matcher.find()) {
                title = matcher.group(1);
            }
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return title;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide URL as argument");
            return;
        }

        // Test cases
        String[] urls = {
            "https://www.example.com",
            "https://www.google.com",
            "https://www.github.com",
            "https://www.wikipedia.org",
            args[0]
        };

        for (String url : urls) {
            System.out.println("URL: " + url);
            System.out.println("Title: " + getPageTitle(url));
            System.out.println();
        }
    }
}
