package CoT.gemini;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.*;
import java.io.IOException;

public class Task47 {

    public static void scrapeAndStore(String websiteUrl, String dbName, String dbUser, String dbPassword) {
        try {
            // 1. Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUser, dbPassword);
            Statement statement = connection.createStatement();

            // 2. Fetch website content
            Document doc = Jsoup.connect(websiteUrl).get();

            // 3. Extract data (example: extracting all links)
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String url = link.attr("abs:href");
                String text = link.text();

                // 4. Store data in database
                String sql = "INSERT INTO links (url, text) VALUES (?, ?)";  // Assuming a table named 'links' exists
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, url);
                preparedStatement.setString(2, text);
                preparedStatement.executeUpdate();
            }


            // 5. Close database connection
            statement.close();
            connection.close();

        } catch (IOException e) {
            System.err.println("Error fetching website content: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases (replace with actual database credentials and website URLs)
        scrapeAndStore("https://www.example.com", "testdb", "user", "password");
        scrapeAndStore("https://www.google.com", "testdb", "user", "password");
        scrapeAndStore("https://www.wikipedia.org", "testdb", "user", "password");
        scrapeAndStore("https://www.amazon.com", "testdb", "user", "password");
        scrapeAndStore("https://www.bing.com", "testdb", "user", "password");
    }
}