package ourMethod.llama31;
public class Task65 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task65 <filename>");
            return;
        }

        String filename = args[0];
        try {
            java.io.File file = new java.io.File(filename);
            if (!file.exists() || !file.isFile()) {
                System.out.println("File does not exist or is not a regular file.");
                return;
            }

            java.util.Scanner scanner = new java.util.Scanner(file);
            scanner.useDelimiter("\\Z"); // Read the entire file
            String content = scanner.next();
            scanner.close();

            System.out.println(content);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}