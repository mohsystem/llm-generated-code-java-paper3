package CoT.llama31;
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
        String[] testCases = {
            "http://example.com",
            "http://www.python.org",
            "http://www.google.com",
            "http://www.bbc.com",
            "http://www.wikipedia.org"
        };

        for (String url : testCases) {
            scrapeAndStore(url, "example.db");
        }
    }

    public static void scrapeAndStore(String url, String dbName) {
        try {
            // Scrape data
            Document doc = Jsoup.connect(url).get();
            Elements paragraphs = doc.select("p");
            String[] data = new String[paragraphs.size()];
            for (int i = 0; i < paragraphs.size(); i++) {
                data[i] = paragraphs.get(i).text();
            }

            // Store in database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS scraped_data (id INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT)").execute();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO scraped_data (data) VALUES (?)");
            for (String item : data) {
                stmt.setString(1, item);
                stmt.executeUpdate();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}