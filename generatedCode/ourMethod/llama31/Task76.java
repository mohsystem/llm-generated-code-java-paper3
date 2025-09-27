package ourMethod.llama31;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class Task76 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task76 <URL>");
            return;
        }
        String url = args[0];
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // Set a timeout to avoid CWE-1088
            connection.setReadTimeout(5000); // Set a timeout to avoid CWE-1088
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                Scanner scanner = new Scanner(connection.getInputStream());
                scanner.useDelimiter("\\Z");
                String content = scanner.next();
                scanner.close();
                Pattern pattern = Pattern.compile("<title>(.*?)</title>");
                Matcher matcher = pattern.matcher(content);
                if (matcher.find()) {
                    System.out.println(matcher.group(1));
                } else {
                    System.out.println("No title found");
                }
            } else {
                System.out.println("Failed to retrieve page. Status code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}