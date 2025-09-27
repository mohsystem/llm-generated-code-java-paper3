package Vanilla.claude;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.*;

public class Task47 {
    private static final String DB_URL = "jdbc:sqlite:webscraper.db";

    private static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS scraped_data (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT," +
                    "link TEXT)";
                    
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void scrapeAndStore(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");

            try (Connection conn = DriverManager.getConnection(DB_URL);
                 PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO scraped_data (title, link) VALUES (?, ?)")) {

                for (Element link : links) {
                    pstmt.setString(1, link.text());
                    pstmt.setString(2, link.attr("abs:href"));
                    pstmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createTable();
        
        // Test cases
        String[] testUrls = {
            "https://example.com",
            "https://wikipedia.org",
            "https://github.com",
            "https://reddit.com",
            "https://news.ycombinator.com"
        };

        for (String url : testUrls) {
            System.out.println("Scraping: " + url);
            scrapeAndStore(url);
        }
    }
}
