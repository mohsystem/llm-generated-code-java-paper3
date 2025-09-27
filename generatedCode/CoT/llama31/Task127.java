package CoT.llama31;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task127 {
    public static void main(String[] args) {
        String[] testCases = {
            "path/to/existing/file.txt",
            "path/to/non/existing/file.txt",
            "path/to/existing/directory",
            "path/to/existing/file_with_no_read_permission.txt",
            "path/to/existing/file_with_no_write_permission.txt"
        };

        for (String testCase : testCases) {
            try {
                readFileAndWriteToTemp(testCase);
            } catch (Exception e) {
                System.out.println("Error processing file: " + testCase + " - " + e.getMessage());
            }
        }
    }

    public static void readFileAndWriteToTemp(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new IOException("File does not exist or is not a file");
        }

        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream("temp_" + file.getName())) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new IOException("Error reading or writing file", e);
        }
    }
}