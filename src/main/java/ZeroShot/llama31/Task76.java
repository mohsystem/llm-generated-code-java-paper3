package ZeroShot.llama31;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Task76 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task76 <URL>");
            return;
        }
        String url = args[0];
        System.out.println(getPageTitle(url));
    }

    public static String getPageTitle(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                Document doc = Jsoup.parse(response.body().string());
                Element title = doc.selectFirst("title");
                return title != null ? title.text() : "No title found";
            } else {
                return "Request failed with status code " + response.code();
            }
        } catch (IOException e) {
            return "Request failed: " + e.getMessage();
        }
    }
}