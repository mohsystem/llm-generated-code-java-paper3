package CoT.openai;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task121 {
    public boolean uploadFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileContent = new byte[(int) file.length()];
            fis.read(fileContent);
            // Process the file content as needed
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        Task121 task = new Task121();
        System.out.println(task.uploadFile("test1.txt")); // Adjust path as needed
        System.out.println(task.uploadFile("test2.txt"));
        System.out.println(task.uploadFile("test3.txt"));
        System.out.println(task.uploadFile("test4.txt"));
        System.out.println(task.uploadFile("test5.txt"));
    }
}