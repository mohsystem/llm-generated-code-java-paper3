package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class Task129 {
    public static String retrieveFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL("http://example.com/files/" + fileName);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine).append("\n");
                }
            }
        } catch (MalformedURLException e) {
            return "Invalid URL";
        } catch (IOException e) {
            return "Error retrieving file";
        }
        return content.toString();
    }

    public static void main(String[] args) {
        System.out.println(retrieveFile("file1.txt"));
        System.out.println(retrieveFile("file2.txt"));
        System.out.println(retrieveFile("file3.txt"));
        System.out.println(retrieveFile("file4.txt"));
        System.out.println(retrieveFile("file5.txt"));
    }
}