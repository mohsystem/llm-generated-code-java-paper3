package ourMethod.codestral;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Task64 {
    public static JsonElement readJsonFromUrl(String url) throws IOException {
        try (Scanner scanner = new Scanner(new URL(url).openStream(), StandardCharsets.UTF_8.toString())) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            return JsonParser.parseString(sb.toString());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a URL as a command line argument.");
            return;
        }
        try {
            JsonElement json = readJsonFromUrl(args[0]);
            System.out.println(json);
        } catch (IOException e) {
            System.err.println("Error reading JSON from URL: " + e.getMessage());
        }
    }
}