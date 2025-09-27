package ZeroShot.llama31;
public class Task69 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task69 <file_path>");
            return;
        }
        String filePath = args[0];
        if (deleteFile(filePath)) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    public static boolean deleteFile(String filePath) {
        return new java.io.File(filePath).delete();
    }
}