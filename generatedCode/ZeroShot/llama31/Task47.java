package ZeroShot.llama31;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task47 {
    private String url;
    private String dbUrl;
    private String user;
    private String password;

    public Task47(String url, String dbUrl, String user, String password) {
        this.url = url;
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;
    }

    public void scrapeAndSave() {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements items = doc.select("div.item");
            try (Connection conn = DriverManager.getConnection(dbUrl, user, password)) {
                conn.prepareStatement("CREATE TABLE IF NOT EXISTS scraped_data (title VARCHAR(255), link VARCHAR(255))").execute();
                for (Element item : items) {
                    String title = item.select("h2").text();
                    String link = item.select("a").attr("href");
                    try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO scraped_data (title, link) VALUES (?, ?)")) {
                        stmt.setString(1, title);
                        stmt.setString(2, link);
                        stmt.execute();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password";
        String[] testCases = {
            "http://example.com",
            "http://example.org",
            "http://example.net",
            "http://example.io",
            "http://example.co"
        };
        for (String url : testCases) {
            Task47 task = new Task47(url, dbUrl, user, password);
            task.scrapeAndSave();
        }
    }
}