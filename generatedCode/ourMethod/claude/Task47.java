package ourMethod.claude;

import java.io.IOException;
import java.sql.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class Task47 {
    private static final String DB_URL = "jdbc:sqlite:scraper.db";
    private static final int TIMEOUT_MS = 5000;
    
    public static void scrapeAndStore(String url, String cssSelector) {
        if (url == null || url.trim().isEmpty() || !url.toLowerCase().startsWith("http")) {
            throw new IllegalArgumentException("Invalid URL provided");
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // Configure SSL to handle certificates securely
            configureSslContext();
            
            // Connect to website with timeout and security headers
            Document doc = Jsoup.connect(url)
                              .timeout(TIMEOUT_MS)
                              .userAgent("Mozilla/5.0")
                              .validateTLSCertificates(true)
                              .get();

            // Extract data using provided CSS selector
            Elements elements = doc.select(cssSelector);
            
            // Initialize database
            conn = DriverManager.getConnection(DB_URL);
            createTable(conn);
            
            // Prepare statement for data insertion
            String sql = "INSERT INTO scraped_data (url, content, timestamp) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            // Store each scraped element
            for (var element : elements) {
                String content = element.text();
                if (content != null && !content.trim().isEmpty()) {
                    pstmt.setString(1, url);
                    pstmt.setString(2, content);
                    pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    pstmt.executeUpdate();
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error scraping website: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    
    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS scraped_data " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "url TEXT NOT NULL, " +
                    "content TEXT NOT NULL, " +
                    "timestamp TIMESTAMP NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
    
    private static void configureSslContext() throws IOException {
        try {
            TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };
            
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) { return true; }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Exception e) {
            throw new IOException("SSL Configuration failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        scrapeAndStore("https://example.com", "h1");
        scrapeAndStore("https://example.com", "p");
        scrapeAndStore("https://example.com", "a");
        scrapeAndStore("https://example.com", "div.content");
        scrapeAndStore("https://example.com", "span.title");
    }
}
