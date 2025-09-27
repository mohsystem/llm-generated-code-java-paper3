package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task76 {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Please provide the URL as a command line argument.");
            return;
        }
        String url = args[0];
        System.out.println("Title: " + getpageTitle(url));
    }

    public static String getpageTitle(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Pattern pattern = Pattern.compile("<title>(.*?)</title>");
            Matcher matcher = pattern.matcher(response.toString());
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "Title not found";
    }
}