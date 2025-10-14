package CoT.openai;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Task50 {
    
    public static String uploadFile(String filePath, String destinationDir) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return "File not found or is not a file.";
        }
        
        try {
            Path destinationPath = Paths.get(destinationDir, file.getName());
            Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            return "File uploaded successfully: " + destinationPath.toString();
        } catch (IOException e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        List<String> testCases = Arrays.asList(
            "test1.txt", 
            "test2.txt", 
            "test3.txt", 
            "test4.txt", 
            "test5.txt"
        );
        String destinationDir = "server/uploads/";
        
        for (String testCase : testCases) {
            System.out.println(uploadFile(testCase, destinationDir));
        }
    }
}