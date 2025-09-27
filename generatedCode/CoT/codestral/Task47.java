package CoT.codestral;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Task47 {
    public static void main(String[] args) throws Exception {
        String url = "http://example.com";
        Document doc = Jsoup.connect(url).get();
        String data = doc.title(); // this is a placeholder for the data you want to scrape

        // replace with your database URL, username, and password
        String dbUrl = "jdbc:mysql://localhost/test";
        String username = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        String sql = "INSERT INTO data_table (data_column) VALUES (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, data);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new row has been inserted successfully.");
        }
    }
}