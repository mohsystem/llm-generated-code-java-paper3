package ZeroShot.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Task70 {
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Please provide a file path as a command-line argument.");
                return;
            }
            String filePath = args[0];
            String fileContent = readFile(filePath);
            System.out.println(fileContent);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }


    }
}