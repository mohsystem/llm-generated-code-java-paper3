package CoT.claude;

import java.io.*;
import java.net.*;
import java.sql.*;
import javax.net.ssl.HttpsURLConnection;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Task47 {
    private static final String DB_URL = "jdbc:sqlite:webscraper.db";
    
    public static void scrapeAndStore(String websiteUrl) {
        try {
            // Configure SSL
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            
            // Create connection
            URL url = new URL(websiteUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(sslContext.getSocketFactory());
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            // Read content
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.replaceAll("[^\\\\x20-\\\\x7e]", ""));
            }
            reader.close();
            
            // Store in database
            Class.forName("org.sqlite.JDBC");
            try (Connection dbConn = DriverManager.getConnection(DB_URL)) {
                // Create table if not exists
                String createTable = "CREATE TABLE IF NOT EXISTS scraped_data " +
                                   "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                   "url TEXT NOT NULL, " +
                                   "content TEXT NOT NULL, " +
                                   "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP)";
                Statement stmt = dbConn.createStatement();
                stmt.execute(createTable);
                
                // Insert data using prepared statement
                String insertData = "INSERT INTO scraped_data (url, content) VALUES (?, ?)";
                PreparedStatement pstmt = dbConn.prepareStatement(insertData);
                pstmt.setString(1, websiteUrl);
                pstmt.setString(2, content.toString());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://example.com",
            "https://google.com",
            "https://github.com",
            "https://wikipedia.org",
            "https://oracle.com"
        };
        
        for (String url : testUrls) {
            System.out.println("Scraping: " + url);
            scrapeAndStore(url);
        }
    }
}
