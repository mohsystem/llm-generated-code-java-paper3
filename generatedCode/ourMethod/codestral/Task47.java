package ourMethod.codestral;
import java.sql.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task47 {
    private static final String DB_URL = "jdbc:mysql://localhost/myDatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        String url = "http://example.com";
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("selector");
            for (Element element : elements) {
                String data = element.text();
                storeData(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void storeData(String data) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO myTable (column) VALUES (?)");
        stmt.setString(1, data);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}