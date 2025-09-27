package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task70 {
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file path as a command line argument.");
            return;
        }
        try {
            String fileContent = readFile(args[0]);
            System.out.println(fileContent);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}