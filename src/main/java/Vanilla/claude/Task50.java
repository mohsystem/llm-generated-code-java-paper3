package Vanilla.claude;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class Task50 {
    private static final int PORT = 8080;
    private static final String UPLOAD_DIR = "uploads";

    // Server class to handle file uploads
    static class FileUploadServer {
        public String handleFileUpload(String fileName, byte[] fileData) {
            try {
                // Create upload directory if it doesn't exist                
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                // Save file to disk
                String filePath = UPLOAD_DIR + File.separator + fileName;
                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(fileData);
                fos.close();
                return "SUCCESS: File '" + fileName + "' uploaded successfully. Size: " + fileData.length + " bytes";
            } catch (IOException e) {
                return "ERROR: Failed to upload file - " + e.getMessage();
            }
        }

        public boolean fileExists(String fileName) {
            File file = new File(UPLOAD_DIR + File.separator + fileName);
            return file.exists();
        }
    }

    // Client class to upload files
    static class FileUploadClient {
        public String uploadFile(String fileName, byte[] fileData, FileUploadServer server) {
            return server.handleFileUpload(fileName, fileData);
        }
    }

    public static void main(String[] args) {
        System.out.println("File Upload System - Test Cases");
        FileUploadServer server = new FileUploadServer();
        FileUploadClient client = new FileUploadClient();
        // Test Case 1: Upload a text file
        System.out.println("Test Case 1: Upload text file");
        String content1 = "Hello, this is a test file!";
        String result1 = client.uploadFile("test1.txt", content1.getBytes(), server);
        System.out.println(result1);
        System.out.println("File exists: " + server.fileExists("test1.txt"));
        System.out.println();
        // Test Case 2: Upload a binary file (simulated)
        System.out.println("Test Case 2: Upload binary file");
        byte[] binaryData = new byte[]{0x48, 0x65, 0x6C, 0x6C, 0x6F};
        String result2 = client.uploadFile("test2.bin", binaryData, server);
        System.out.println(result2);
        System.out.println("File exists: " + server.fileExists("test2.bin"));
        System.out.println();
        // Test Case 3: Upload a larger file
        System.out.println("Test Case 3: Upload larger file");
        StringBuilder largeContent = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            largeContent.append("Line " + i + ": This is test data.        ");
        }
        String result3 = client.uploadFile(" test3.log                ", largeContent.toString().getBytes(), server);
        System.out.println(result3);        System.out.println("                File exists:" +
                server.fileExists(" test3.log        "));
        System.out.println();
        // Test Case 4: Upload file with special characters in name
        System.out.println("        Test Case 4:Upload file with special characters ");
        String content4 = " Special file content        ";
        String result4 = client.uploadFile(" test_file - 4. txt        ", content4.getBytes(), server);
        System.out.println(result4);        System.out.println(" File exists:        "
                + server.fileExists(" test_file - 4. txt        "));
        System.out.println();
        // Test Case 5: Upload empty file
        System.out.println("        Test Case 5:Upload empty file ");
        String result5 = client.uploadFile(" empty.txt        ", new byte[0], server);
        System.out.println(result5);        System.out.println(" File exists:        " + server.fileExists(" empty.txt "));
        System.out.println();
    }
}
