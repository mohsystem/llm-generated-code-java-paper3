package ZeroShot.llama31;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task127 {
    public static void main(String[] args) {
        String[] testCases = {
            "test1.txt",
            "test2.txt",
            "nonexistentfile.txt",
            "test3.txt",
            "test4.txt"
        };

        for (String testCase : testCases) {
            try {
                readFileAndWriteToTemp(testCase);
                System.out.println("File " + testCase + " processed successfully.");
            } catch (Exception e) {
                System.out.println("Error processing file " + testCase + ": " + e.getMessage());
            }
        }
    }

    public static void readFileAndWriteToTemp(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IOException("File " + fileName + " does not exist.");
        }

        try (FileReader reader = new FileReader(file);
             FileWriter writer = new FileWriter("temp_" + fileName)) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
        }
    }
}