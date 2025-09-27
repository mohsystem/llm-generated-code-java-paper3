package ourMethod.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {

    public static String getPageTitle(String urlString) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static void main(String[] args) {
        String[] testUrls = {
            "https://www.example.com",
            "https://www.google.com",
            "https://www.github.com",
            "https://www.stackoverflow.com",
            "https://www.wikipedia.org"
        };

        for (String url : testUrls) {
            System.out.println("Title of " + url + ": " + getPageTitle(url));
        }
    }
}