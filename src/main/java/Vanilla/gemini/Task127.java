package Vanilla.gemini;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class Task127 {
    public static void copyFile(String sourcePath, String destPath) throws IOException {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        if (!sourceFile.exists()) {
            throw new FileNotFoundException("Source file not found: " + sourcePath);
        }

        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(destFile)) {

             Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        }
    }


    public static void main(String[] args) {
        try {
            copyFile("test1.txt", "temp/test1_copy.txt");
            System.out.println("File copied successfully: test1.txt");

            copyFile("test2.txt", "temp/test2_copy.txt"); // test2.txt may not exist
            System.out.println("File copied successfully: test2.txt");



            copyFile("test3.txt", "temp/test3_copy.txt"); 
            System.out.println("File copied successfully: test3.txt");


            copyFile("test4.txt", "temp/test4_copy.txt");
            System.out.println("File copied successfully: test4.txt");


            copyFile("test5.txt", "temp/test5_copy.txt");
            System.out.println("File copied successfully: test5.txt");

        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}