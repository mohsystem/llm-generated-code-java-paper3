package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task65 {
    public static String readFile(String fileName) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return data.toString();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Task65 <filename>");
            return;
        }
        String data = readFile(args[0]);
        if (!data.isEmpty()) {
            System.out.println(data);
        }
    }
}