package ZeroShot.codestral;
// Java code:
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.sql.*;

public class Task47 {
    public static void main(String[] args) throws Exception {
        scrapeAndStore("http://example.com");
    }

    public static void scrapeAndStore(String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        // Parse the document to extract data
        // ...

        // Connect to database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement stmt = conn.createStatement();

        // Insert data into database
        // ...

        stmt.close();
        conn.close();
    }
}