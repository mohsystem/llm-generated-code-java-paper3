package ourMethod.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task39 {
    public static String displayFileContent(String filename) {
        try {
            Path filePath = Paths.get(filename).toAbsolutePath().normalize();
            if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
                return "File not found.";
            }

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("sh", "-c", "cat " + filePath.toString());
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(System.lineSeparator());
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error displaying file.";
            }

            return output.toString();
        } catch (Exception e) {
            return "Exception occurred: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(displayFileContent("test1.txt"));
        System.out.println(displayFileContent("test2.txt"));
        System.out.println(displayFileContent("test3.txt"));
        System.out.println(displayFileContent("test4.txt"));
        System.out.println(displayFileContent("test5.txt"));
    }
}