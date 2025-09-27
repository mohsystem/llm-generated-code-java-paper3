package Vanilla.llama31;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task47 {
    public static void scrapeAndStore(String url, String dbHost, String dbUser, String dbPassword, String dbName) {
        try {
            // Web scraping
            Document doc = Jsoup.connect(url).get();
            Elements data = doc.select("p");  // Example: Extract all paragraphs

            // Store data in MySQL database
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + "/" + dbName, dbUser, dbPassword);
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS scraped_data (id INT AUTO_INCREMENT PRIMARY KEY, data TEXT)").execute();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO scraped_data (data) VALUES (?)");
            for (Element item : data) {
                stmt.setString(1, item.text());
                stmt.executeUpdate();
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "http://example.com";
        String dbHost = "localhost";
        String dbUser = "root";
        String dbPassword = "password";
        String dbName = "scraped_data";
        scrapeAndStore(url, dbHost, dbUser, dbPassword, dbName);
    }
}