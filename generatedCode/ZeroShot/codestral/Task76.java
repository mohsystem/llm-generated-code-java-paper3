package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task76 {
    public static void main(String[] args) {
        System.out.println(getPageTitle(args[0]));
    }

    public static String getPageTitle(String url) {
        String title = "";
        try {
            Document document = Jsoup.parse(new URL(url), 3000);
            Elements elements = document.select("title");
            for (Element element : elements) {
                title = element.text();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }
}