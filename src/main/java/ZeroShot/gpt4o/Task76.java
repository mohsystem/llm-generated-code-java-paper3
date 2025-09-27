package ZeroShot.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static String getPageTitle(String urlString) {
        String title = null;
        try {
            URL url = new URL(urlString);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(content.toString());
                if (matcher.find()) {
                    title = matcher.group(1);
                }
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String arg : args) {
                System.out.println("Title: " + getPageTitle(arg));
            }
        }
    }
}