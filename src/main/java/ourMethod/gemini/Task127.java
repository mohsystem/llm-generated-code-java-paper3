package ourMethod.gemini;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task127 {

    public static void copyFileToTemp(String sourceFilePath) throws IOException {
        // Check if the source file exists and is a file (not a directory)
        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists() || !sourceFile.isFile()) {
            throw new IOException("Source file not found or not a file: " + sourceFilePath);
        }

        try {
            // Create a temporary file
            Path tempFile = Files.createTempFile("temp_", ".tmp"); 

            try (FileInputStream inputStream = new FileInputStream(sourceFile);
                 FileOutputStream outputStream = new FileOutputStream(tempFile.toFile())) {

                byte[] buffer = new byte[4096]; // Use a reasonable buffer size
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
           // tempFile.toFile().deleteOnExit(); // Delete temp file on JVM exit

        } catch (IOException e) {
            throw new IOException("Error copying file to temporary location: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        String testFile1 = "test1.txt";
        String testFile2 = "test2.txt"; // Non-existent file
        String testDir = "test_dir"; // Directory, not a file

        try {
            createTestFile(testFile1, "Test file 1 content"); // Create a test file
            createTestDirectory(testDir);


            copyFileToTemp(testFile1);
            System.out.println("Copied " + testFile1 + " successfully.");


            copyFileToTemp(testFile2); 

        } catch (IOException e) {
            System.err.println("Test case failed: " + e.getMessage());
        }

        try {
            copyFileToTemp(testDir);
        } catch (IOException e) {
            System.err.println("Test case failed: " + e.getMessage());
        }


        try {
            copyFileToTemp("test3.txt"); 
        } catch (IOException e) {
            System.err.println("Test case failed: " + e.getMessage());
        }

        try {
            copyFileToTemp("abc/test4.txt"); 

        } catch (IOException e) {
            System.err.println("Test case failed: " + e.getMessage());
        }
        try {
            copyFileToTemp("test5.txt"); 

        } catch (IOException e) {
            System.err.println("Test case failed: " + e.getMessage());
        }
    }

    private static void createTestFile(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content);
    }


    private static void createTestDirectory(String dirPath) throws IOException {
        Files.createDirectories(Path.of(dirPath));
    }
}