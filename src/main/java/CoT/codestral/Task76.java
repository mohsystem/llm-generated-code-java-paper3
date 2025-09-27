package CoT.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static String getPageTitle(String url) throws Exception {
        URLConnection connection = new URL(url).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder html = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            html.append(line);
        }
        reader.close();

        Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html.toString());
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "No title found";
    }

    public static void main(String[] args) {
        try {
            System.out.println(getPageTitle(args[0]));
            System.out.println(getPageTitle(args[1]));
            System.out.println(getPageTitle(args[2]));
            System.out.println(getPageTitle(args[3]));
            System.out.println(getPageTitle(args[4]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}