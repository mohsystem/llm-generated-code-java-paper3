package ourMethod.openai;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Task50 {

    public static String uploadFile(String fileName, byte[] fileContent) {
        try {
            Path path = Paths.get("server_storage/" + sanitizeFileName(fileName));
            Files.createDirectories(path.getParent());
            Files.write(path, fileContent);
            return "File uploaded successfully: " + sanitizeFileName(fileName);
        } catch (IOException e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }

    private static String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
    }

    public static void main(String[] args) {
        // Test cases
        byte[] content1 = "This is a test file".getBytes();
        byte[] content2 = "Another test file".getBytes();
        byte[] content3 = "File with special chars !@#$".getBytes();
        byte[] content4 = "Empty file".getBytes();
        byte[] content5 = "File with long content".getBytes();

        System.out.println(uploadFile("testfile1.txt", content1));
        System.out.println(uploadFile("testfile2.txt", content2));
        System.out.println(uploadFile("special!file@name.txt", content3));
        System.out.println(uploadFile("empty.txt", content4));
        System.out.println(uploadFile("longfile.txt", content5));
    }
}