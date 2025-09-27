package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a URL as a command line argument.");
            return;
        }
        String url = args[0];
        try {
            String title = getPageTitle(url);
            System.out.println("Page title: " + title);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static String getPageTitle(String urlString) throws Exception {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();

        Pattern pattern = Pattern.compile("<title>(.+?)</title>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content.toString());
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new Exception("Page title not found.");
        }
    }
}