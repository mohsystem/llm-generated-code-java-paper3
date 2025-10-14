package ourMethodv2.gpt4o;
// Java code for scraping data from a given website and storing it in a local database.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task47 {
    public static void scrapeAndStore(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements dataElements = doc.select("div.data"); // Example selector

            // Database connection
            Connection conn = DriverManager.getConnection("jdbc:sqlite:local.db");
            String sql = "INSERT INTO scraped_data (data) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            for (Element el : dataElements) {
                String data = el.text();
                pstmt.setString(1, data);
                pstmt.executeUpdate();
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        scrapeAndStore("http://example.com");
        scrapeAndStore("http://example.com/page1");
        scrapeAndStore("http://example.com/page2");
        scrapeAndStore("http://example.com/page3");
        scrapeAndStore("http://example.com/page4");
    }
}