package ourMethod.claude;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class Task47 {
    private static final int MAX_URL_LENGTH = 2048;
    private static final int MAX_CONTENT_LENGTH = 10485760; // 10MB
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 10000;
    private static final Pattern URL_PATTERN = Pattern.compile(
        "^https://[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}(/[a-zA-Z0-9._~:/?#\\\\[\\\\]@!$&'()*+,;=-]*)?$"
    );

    public static class ScrapedData {
        public final String url;
        public final String content;
        public final String contentHash;
        public final long timestamp;

        public ScrapedData(String url, String content, String contentHash, long timestamp) {
            this.url = url;
            this.content = content;
            this.contentHash = contentHash;
            this.timestamp = timestamp;
        }
    }

    public static String validateAndNormalizeUrl(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        
        String trimmed = url.trim();
        if (trimmed.length() > MAX_URL_LENGTH) {
            throw new IllegalArgumentException("URL exceeds maximum length");
        }
        
        if (!URL_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException("Invalid URL format. Only HTTPS URLs are allowed");
        }
        
        return trimmed;
    }

    public static String scrapeWebsite(String urlString) throws Exception {
        urlString = validateAndNormalizeUrl(urlString);
        
        URI uri = new URI(urlString);
        URL url = uri.toURL();
        
        SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
        sslContext.init(null, null, null);
        
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(sslContext.getSocketFactory());
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(CONNECT_TIMEOUT);
        connection.setReadTimeout(READ_TIMEOUT);
        connection.setRequestProperty("User-Agent", "SecureScraper/1.0");
        connection.setInstanceFollowRedirects(false);
        
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            connection.disconnect();
            throw new IOException("HTTP error code: " + responseCode);
        }
        
        String contentType = connection.getContentType();
        if (contentType == null || !contentType.toLowerCase().contains("text")) {
            connection.disconnect();
            throw new IOException("Invalid content type");
        }
        
        int contentLength = connection.getContentLength();
        if (contentLength > MAX_CONTENT_LENGTH) {
            connection.disconnect();
            throw new IOException("Content exceeds maximum allowed size");
        }
        
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            int totalRead = 0;
            while ((line = reader.readLine()) != null) {
                totalRead += line.length();
                if (totalRead > MAX_CONTENT_LENGTH) {
                    throw new IOException("Content exceeds maximum allowed size");
                }
                content.append(line).append("\n");
            }
        } finally {
            connection.disconnect();
        }
        
        return content.toString();
    }

    public static String calculateHash(String content) throws Exception {
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(content.getBytes(StandardCharsets.UTF_8));
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        
        return hexString.toString();
    }

    public static Connection initializeDatabase(String dbPath) throws SQLException {
        if (dbPath == null || dbPath.isEmpty()) {
            throw new IllegalArgumentException("Database path cannot be null or empty");
        }
        
        if (!dbPath.matches("^[a-zA-Z0-9_./:-]+\\\\.db$")) {
            throw new IllegalArgumentException("Invalid database path format");
        }
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        
        String createTableSQL = "CREATE TABLE IF NOT EXISTS scraped_data (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "url TEXT NOT NULL, " +
                                "content TEXT NOT NULL, " +
                                "content_hash TEXT NOT NULL, " +
                                "timestamp INTEGER NOT NULL)";
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        }
        
        return conn;
    }

    public static void storeData(Connection conn, ScrapedData data) throws SQLException {
        if (conn == null || data == null) {
            throw new IllegalArgumentException("Connection and data cannot be null");
        }
        
        String insertSQL = "INSERT INTO scraped_data (url, content, content_hash, timestamp) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, data.url);
            pstmt.setString(2, data.content);
            pstmt.setString(3, data.contentHash);
            pstmt.setLong(4, data.timestamp);
            pstmt.executeUpdate();
        }
    }

    public static List<ScrapedData> retrieveData(Connection conn, String url) throws SQLException {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        
        List<ScrapedData> results = new ArrayList<>();
        String selectSQL;
        
        if (url != null && !url.isEmpty()) {
            selectSQL = "SELECT url, content, content_hash, timestamp FROM scraped_data WHERE url = ? ORDER BY timestamp DESC";
        } else {
            selectSQL = "SELECT url, content, content_hash, timestamp FROM scraped_data ORDER BY timestamp DESC";
        }
        
        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            if (url != null && !url.isEmpty()) {
                pstmt.setString(1, url);
            }
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    results.add(new ScrapedData(
                        rs.getString("url"),
                        rs.getString("content"),
                        rs.getString("content_hash"),
                        rs.getLong("timestamp")
                    ));
                }
            }
        }
        
        return results;
    }

    public static void main(String[] args) {
        System.out.println("=== Web Scraper with Local Database - Test Cases ===\\n");
        
        // Test Case 1: Initialize database
        System.out.println("Test 1: Initialize database");
        Connection conn = null;
        try {
            conn = initializeDatabase("test_scraper.db");
            System.out.println("✓ Database initialized successfully\\n");
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage() + "\n");
        }
        
        // Test Case 2: Validate URL - valid HTTPS
        System.out.println("Test 2: Validate valid HTTPS URL");
        try {
            String validUrl = "https://example.com/page";
            String normalized = validateAndNormalizeUrl(validUrl);
            System.out.println("✓ Valid URL accepted: " + normalized + "\n");
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage() + "\n");
        }
        
        // Test Case 3: Validate URL - reject HTTP
        System.out.println("Test 3: Reject insecure HTTP URL");
        try {
            String insecureUrl = "http://example.com/page";
            validateAndNormalizeUrl(insecureUrl);
            System.out.println("✗ Should have rejected HTTP URL\\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ HTTP URL correctly rejected: " + e.getMessage() + "\n");
        } catch (Exception e) {
            System.err.println("✗ Unexpected error: " + e.getMessage() + "\n");
        }
        
        // Test Case 4: Calculate hash
        System.out.println("Test 4: Calculate content hash");
        try {
            String content = "Sample content for hashing";
            String hash = calculateHash(content);
            System.out.println("✓ Hash calculated: " + hash + "\n");
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage() + "\n");
        }
        
        // Test Case 5: Store and retrieve data
        System.out.println("Test 5: Store and retrieve data");
        if (conn != null) {
            try {
                String testUrl = "https://example.com/test";
                String testContent = "Test content";
                String testHash = calculateHash(testContent);
                long timestamp = Instant.now().getEpochSecond();
                
                ScrapedData data = new ScrapedData(testUrl, testContent, testHash, timestamp);
                storeData(conn, data);
                System.out.println("✓ Data stored successfully");
                
                List<ScrapedData> retrieved = retrieveData(conn, testUrl);
                if (!retrieved.isEmpty() && retrieved.get(0).url.equals(testUrl)) {
                    System.out.println("✓ Data retrieved successfully: " + retrieved.size() + " record(s)\\n");
                } else {
                    System.out.println("✗ Data retrieval mismatch\\n");
                }
            } catch (Exception e) {
                System.err.println("✗ Error: " + e.getMessage() + "\n");
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    Files.deleteIfExists(Paths.get("test_scraper.db"));
                } catch (Exception e) {
                    System.err.println("Cleanup error: " + e.getMessage());
                }
            }
        }
        
        System.out.println("=== All tests completed ===");
    }
}
