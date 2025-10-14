package Vanilla.openai;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task50 {

    public String uploadFile(String fileName, byte[] fileContent) {
        try {
            File file = new File("uploads/" + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(fileContent);
            fos.close();
            return "File uploaded successfully: " + fileName;
        } catch (IOException e) {
            return "Failed to upload file: " + fileName;
        }
    }

    public static void main(String[] args) {
        Task50 task = new Task50();
        System.out.println(task.uploadFile("test1.txt", "Hello World!".getBytes()));
        System.out.println(task.uploadFile("test2.txt", "Java Programming".getBytes()));
        System.out.println(task.uploadFile("test3.txt", "File Upload Test".getBytes()));
        System.out.println(task.uploadFile("test4.txt", "Sample Data".getBytes()));
        System.out.println(task.uploadFile("test5.txt", "Another Test".getBytes()));
    }
}