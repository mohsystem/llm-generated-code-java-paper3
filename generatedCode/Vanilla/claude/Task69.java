package Vanilla.claude;

import java.io.File;

public class Task69 {
    public static boolean deleteFile(String filePath) {
        try {
            File file = new File(filePath);
            if(file.exists()) {
                return file.delete();
            }
            return false;
        } catch(Exception e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testPaths = {
            "test1.txt",
            "folder/test2.txt", 
            "nonexistent.txt",
            "test3.doc",
            "folder/subfolder/test4.pdf"
        };
        
        for(String path : testPaths) {
            boolean result = deleteFile(path);
            System.out.println("Deleting " + path + ": " + (result ? "Success" : "Failed"));
        }
    }
}
