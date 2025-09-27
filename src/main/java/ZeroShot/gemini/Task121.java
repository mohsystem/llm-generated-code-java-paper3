package ZeroShot.gemini;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class Task121 {

    private static final String UPLOAD_DIRECTORY = "uploads";

    public static String uploadFile(InputStream fileInputStream, String fileName) throws IOException, NoSuchAlgorithmException {
        createUploadDirectory();

        Path filePath = Paths.get(UPLOAD_DIRECTORY, fileName);

        // Check for path traversal vulnerabilities
        if (!filePath.normalize().toString().startsWith(UPLOAD_DIRECTORY + File.separator)) {
            throw new IOException("Invalid file path.");
        }


        try (FileOutputStream outputStream = new FileOutputStream(filePath.toFile())) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }


        // Calculate checksum to verify file integrity
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] fileBytes = Files.readAllBytes(filePath);
        byte[] checksum = md.digest(fileBytes);


        return "File uploaded successfully. Checksum: " + bytesToHex(checksum);
    }

    private static void createUploadDirectory() throws IOException {
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            if (!uploadDir.mkdirs()) {
                throw new IOException("Could not create upload directory.");
            }
        }
    }


    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        // Mock test cases (replace with actual input streams)

        byte[] testData1 = "Test data 1".getBytes();
        byte[] testData2 = "Test data 2".getBytes();
        byte[] testData3 = "Test data 3".getBytes();
        byte[] testData4 = "Test data 4".getBytes();
        byte[] testData5 = "Test data 5".getBytes();


        InputStream inputStream1 = new java.io.ByteArrayInputStream(testData1);
        InputStream inputStream2 = new java.io.ByteArrayInputStream(testData2);
        InputStream inputStream3 = new java.io.ByteArrayInputStream(testData3);
        InputStream inputStream4 = new java.io.ByteArrayInputStream(testData4);
        InputStream inputStream5 = new java.io.ByteArrayInputStream(testData5);



        System.out.println(uploadFile(inputStream1, "test1.txt"));
        System.out.println(uploadFile(inputStream2, "test2.txt"));
        System.out.println(uploadFile(inputStream3, "test3.txt"));
        System.out.println(uploadFile(inputStream4, "test4.txt"));
        System.out.println(uploadFile(inputStream5, "test5.txt"));
    }
}