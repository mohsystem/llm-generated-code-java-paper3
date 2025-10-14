package ourMethod.openai;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task47 {
    private static final String DB_URL = "jdbc:sqlite:localdata.db";

    public static void scrapeAndStore(String url) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS data (title TEXT)");

                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("h1"); // Example: scrape all h1 elements

                for (Element element : elements) {
                    String title = element.text();
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO data(title) VALUES(?)");
                    pstmt.setString(1, title);
                    pstmt.executeUpdate();
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        scrapeAndStore("http://example.com");
        scrapeAndStore("http://example.org");
        scrapeAndStore("http://example.net");
        scrapeAndStore("http://example.edu");
        scrapeAndStore("http://example.gov");
    }
}