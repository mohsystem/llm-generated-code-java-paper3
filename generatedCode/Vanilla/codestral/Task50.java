package Vanilla.codestral;
// Java
public class Task50 {
    public static String uploadFile(byte[] fileData) {
        // Here you would handle the file uploading to the server
        // For simplicity, we're just returning a confirmation message
        return "File uploaded successfully.";
    }

    public static void main(String[] args) {
        // Test cases
        byte[] fileData = new byte[1024]; // Replace this with actual file data
        System.out.println(uploadFile(fileData));
    }
}