package Vanilla.codestral;
// Java code using jsoup and sqlite-jdbc
// This code assumes that the website returns JSON data
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.sql.*;

public class Task47 {
    public static void main(String[] args) throws Exception {
        // Fetch JSON data from the website
        Document doc = Jsoup.connect("http://example.com").ignoreContentType(true).get();
        String json = doc.text();

        // Parse JSON and store in SQLite database
        // This part would require a JSON parser and is not shown here for simplicity
        // After parsing, you can insert data into the database like this:
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO MyTable (column1, column2) VALUES (value1, value2);");
    }
}