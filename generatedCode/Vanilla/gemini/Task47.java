package Vanilla.gemini;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.*;

public class Task47 {

    public static void scrapeAndStore(String url, String dbUrl, String dbUser, String dbPassword) throws SQLException {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("title"); // Example: scraping titles

            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();

            // Create table if it doesn't exist
            statement.execute("CREATE TABLE IF NOT EXISTS scraped_data (title VARCHAR(255))");

            for (Element element : elements) {
                String title = element.text();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO scraped_data (title) VALUES (?)");
                preparedStatement.setString(1, title);
                preparedStatement.executeUpdate();
            }


            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws SQLException {
       scrapeAndStore("https://www.example.com", "jdbc:sqlite:mydatabase.db", "", "");
       scrapeAndStore("https://www.google.com", "jdbc:sqlite:mydatabase.db", "", "");
       scrapeAndStore("https://www.bing.com", "jdbc:sqlite:mydatabase.db", "", "");
       scrapeAndStore("https://www.wikipedia.org", "jdbc:sqlite:mydatabase.db", "", "");
       scrapeAndStore("https://www.yahoo.com", "jdbc:sqlite:mydatabase.db", "", "");
    }
}