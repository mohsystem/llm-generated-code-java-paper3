package ZeroShot.gpt4o;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task47 {

    public static void main(String[] args) {
        String url = "http://example.com"; // Test URL
        for (int i = 0; i < 5; i++) { // 5 test cases
            scrapeAndStore(url);
        }
    }

    public static void scrapeAndStore(String url) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Scraping the website
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("p"); // Example selector

            // Connect to database
            conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            String sql = "INSERT INTO data(content) VALUES(?)";
            pstmt = conn.prepareStatement(sql);

            // Store each element
            for (Element element : elements) {
                pstmt.setString(1, element.text());
                pstmt.executeUpdate();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}