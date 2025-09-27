package ourMethod.gemini;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.*;

public class Task47 {

    public static void scrapeAndStore(String websiteUrl, String dbUrl, String username, String password) {
        try {
            // 1. Scrape data using Jsoup
            Document doc = Jsoup.connect(websiteUrl).get();
            Elements elements = doc.select("title"); // Example: Select title element, modify selector as needed

            // 2. Store data in the database
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();

            // Example: Create table if it doesn't exist
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS scraped_data (title TEXT)");

            for (Element element : elements) {
                String title = element.text();

                // Prepared statement to prevent SQL injection
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO scraped_data (title) VALUES (?)");
                preparedStatement.setString(1, title);
                preparedStatement.executeUpdate();
            }

            statement.close();
            connection.close();

        } catch (IOException e) {
            System.err.println("Error scraping website: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error storing data in database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlite:mydatabase.db"; // Example using SQLite, modify as needed

        // Test cases
        scrapeAndStore("https://www.example.com", dbUrl, "", "");
        scrapeAndStore("https://www.google.com", dbUrl, "", "");
        scrapeAndStore("https://www.wikipedia.org", dbUrl, "", "");
        scrapeAndStore("https://www.amazon.com", dbUrl, "", "");
        scrapeAndStore("https://www.cnn.com", dbUrl, "", "");
    }
}