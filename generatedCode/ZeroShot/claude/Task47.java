package ZeroShot.claude;

import java.io.*;
import java.net.*;
import java.sql.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Task47 {
    public static void scrapeAndStore(String url, String dbPath) {
        try {
            // Input validation
            if (url == null || url.isEmpty() || !url.startsWith("http")) {
                throw new IllegalArgumentException("Invalid URL");
            }
            
            // Connect to website with timeout and user-agent
            Document doc = Jsoup.connect(url)
                              .timeout(5000)
                              .userAgent("Mozilla/5.0")
                              .get();
            
            String title = doc.title();
            String content = doc.body().text();
            
            // SQL injection prevention using prepared statement
            String dbUrl = "jdbc:sqlite:" + dbPath;
            try (Connection conn = DriverManager.getConnection(dbUrl)) {
                // Create table if not exists
                String createTable = "CREATE TABLE IF NOT EXISTS scraped_data " +
                                   "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                   "url TEXT NOT NULL, title TEXT, content TEXT)";
                                   
                PreparedStatement createStmt = conn.prepareStatement(createTable);
                createStmt.execute();
                
                // Insert data
                String insertQuery = "INSERT INTO scraped_data (url, title, content) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, url);
                pstmt.setString(2, title);
                pstmt.setString(3, content);
                pstmt.executeUpdate();
            }
        } catch (IOException e) {
            System.err.println("Error scraping website: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        scrapeAndStore("https://example.com", "scraper.db");
        scrapeAndStore("https://opensource.org", "scraper.db");
        scrapeAndStore("https://apache.org", "scraper.db");
        scrapeAndStore("https://github.com", "scraper.db");
        scrapeAndStore("https://wikipedia.org", "scraper.db");
    }
}
