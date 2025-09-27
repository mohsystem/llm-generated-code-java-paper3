package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static String getPageTitle(String urlString) throws Exception {
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(sb.toString());
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "No title found";
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(getPageTitle(args[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}