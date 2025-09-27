package ZeroShot.gemini;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.*;

public class Task47 {

    public static void scrapeAndStore(String url, String dbUrl, String username, String password) throws Exception {
        // Validate input URL (partially - more robust checks can be added)
        if (!url.startsWith("http")) {
            throw new IllegalArgumentException("Invalid URL format");
        }


        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("title, h1, h2, h3, p, a"); // Example elements - can be customized

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO scraped_data (tag, content, link) VALUES (?, ?, ?)")) {

            for (Element element : elements) {
                String tag = element.tagName();
                String content = element.text();
                String link = element.attr("href");

                stmt.setString(1, tag);
                stmt.setString(2, content);
                stmt.setString(3, link);
                stmt.executeUpdate();
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Replace with actual database credentials
            String dbUrl = "jdbc:sqlite:scraped_data.db"; // Example: SQLite
            String username = "";
            String password = "";

            // Create table if it doesn't exist
            try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS scraped_data (id INTEGER PRIMARY KEY AUTOINCREMENT, tag TEXT, content TEXT, link TEXT)");
            }



            scrapeAndStore("https://www.example.com", dbUrl, username, password);
            scrapeAndStore("https://www.google.com", dbUrl, username, password);
            scrapeAndStore("https://www.wikipedia.org", dbUrl, username, password);
            scrapeAndStore("https://www.amazon.com", dbUrl, username, password);
            scrapeAndStore("https://www.bbc.com", dbUrl, username, password);

            System.out.println("Data scraped and stored successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}