package ourMethod.llama31;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task47 {
    public static void main(String[] args) {
        String url = "http://example.com";
        String dbUrl = "jdbc:sqlite:example.db";
        scrapeAndSave(url, dbUrl);
    }

    public static void scrapeAndSave(String url, String dbUrl) {
        try {
            // Fetch HTML content
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10000).get();

            // Extract links
            Elements links = doc.select("a[href]");
            String[] linkArray = new String[links.size()];
            int i = 0;
            for (Element link : links) {
                linkArray[i++] = link.attr("href");
            }

            // Save to database
            try (Connection conn = DriverManager.getConnection(dbUrl)) {
                conn.prepareStatement("CREATE TABLE IF NOT EXISTS links (link TEXT)").execute();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO links (link) VALUES (?)");
                for (String link : linkArray) {
                    stmt.setString(1, link);
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}