package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static String getPageTitle(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            String htmlContent = content.toString();
            Pattern pattern = Pattern.compile("<title>(.*?)</title>");
            Matcher matcher = pattern.matcher(htmlContent);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                for (String url : args) {
                    String title = getPageTitle(url);
                    System.out.println("Title: " + (title != null ? title : "Not found"));
                }
            } else {
                System.out.println("Please provide URL(s) as command line arguments.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}