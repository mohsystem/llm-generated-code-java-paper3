package CoT.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

class Task121 {

    public static String uploadFile(String uploadDirectory, byte[] fileData, String fileName) throws IOException {
        // Validate inputs
        if (uploadDirectory == null || uploadDirectory.isEmpty() || fileData == null || fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        // Sanitize filename to prevent directory traversal attacks
        String sanitizedFileName = fileName.replaceAll("[^a-zA-Z0-9._-]", "_");

         // Add a random UUID to the filename to prevent filename collisions and overwriting
        String uniqueFileName = UUID.randomUUID().toString() + "_" + sanitizedFileName;

        // Create the upload directory if it doesn't exist
        Path uploadPath = Paths.get(uploadDirectory);
        Files.createDirectories(uploadPath);

        // Create the destination file path
        Path filePath = uploadPath.resolve(uniqueFileName);

        // Write the file data to the destination file
        Files.write(filePath, fileData);

        return filePath.toString();
    }


    public static void main(String[] args) throws IOException {
        String uploadDir = "uploads";
        byte[] fileData1 = "Test file content 1".getBytes();
        byte[] fileData2 = "Test file content 2".getBytes();
        String fileName1 = "test1.txt";
        String fileName2 = "test2.txt";
        String fileName3 = "../test3.txt"; //test directory traversal vulnerability fix
        String fileName4 = "test4.txt";
        String fileName5 = "test5.txt";

        System.out.println(uploadFile(uploadDir, fileData1, fileName1));
        System.out.println(uploadFile(uploadDir, fileData2, fileName2));
        System.out.println(uploadFile(uploadDir, fileData1, fileName3)); //test directory traversal vulnerability fix
        System.out.println(uploadFile(uploadDir, fileData2, fileName4));
        System.out.println(uploadFile(uploadDir, fileData1, fileName5));

    }

}