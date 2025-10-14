package ourMethod.claude;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Pattern;

public class Task50 {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final int MAX_FILENAME_LENGTH = 255;
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_\\\\-\\\\.]+$");
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList(
            "txt", "pdf", "jpg", "jpeg", "png", "gif", "doc", "docx", "csv"
    ));

    private final Path uploadDirectory;

    public Task50(String baseDir) throws IOException {
        if (baseDir == null || baseDir.trim().isEmpty()) {
            throw new IllegalArgumentException("Base directory cannot be null or empty");
        }

        this.uploadDirectory = Paths.get(baseDir).toAbsolutePath().normalize();

        if (!Files.exists(uploadDirectory)) {
            Files.createDirectories(uploadDirectory);
        }

        if (!Files.isDirectory(uploadDirectory)) {
            throw new IllegalArgumentException("Upload path must be a directory");
        }
    }

    private String sanitizeFilename(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }

        filename = filename.trim();

        if (filename.length() > MAX_FILENAME_LENGTH) {
            throw new IllegalArgumentException("Filename too long");
        }

        if (!SAFE_FILENAME_PATTERN.matcher(filename).matches()) {
            throw new IllegalArgumentException("Filename contains invalid characters");
        }

        String extension = getFileExtension(filename);
        if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
            throw new IllegalArgumentException("File type not allowed");
        }

        return filename;
    }

    private String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot > 0 && lastDot < filename.length() - 1) {
            return filename.substring(lastDot + 1);
        }
        return "";
    }

    private Path validateUploadPath(String filename) throws IOException {
        String sanitized = sanitizeFilename(filename);
        Path targetPath = uploadDirectory.resolve(sanitized).normalize();

        if (!targetPath.startsWith(uploadDirectory)) {
            throw new SecurityException("Path traversal attempt detected");
        }

        if (Files.isSymbolicLink(targetPath)) {
            throw new SecurityException("Symbolic links are not allowed");
        }

        return targetPath;
    }

    public String uploadFile(String filename, byte[] content) {
        if (content == null) {
            return "ERROR: File content cannot be null";
        }

        if (content.length == 0) {
            return "ERROR: File content cannot be empty";
        }

        if (content.length > MAX_FILE_SIZE) {
            return "ERROR: File size exceeds maximum allowed size";
        }

        try {
            Path targetPath = validateUploadPath(filename);

            String uniqueFilename = generateUniqueFilename(filename);
            Path uniquePath = uploadDirectory.resolve(uniqueFilename).normalize();

            if (!uniquePath.startsWith(uploadDirectory)) {
                return "ERROR: Invalid file path";
            }

            Path tempFile = Files.createTempFile(uploadDirectory, "upload_", ".tmp");

            try {
                Files.write(tempFile, content, StandardOpenOption.WRITE);

                Files.move(tempFile, uniquePath, StandardCopyOption.ATOMIC_MOVE,
                        StandardCopyOption.REPLACE_EXISTING);

                Set<PosixFilePermission> perms = new HashSet<>();
                perms.add(PosixFilePermission.OWNER_READ);
                perms.add(PosixFilePermission.OWNER_WRITE);

                try {
                    Files.setPosixFilePermissions(uniquePath, perms);
                } catch (UnsupportedOperationException e) {
                    // Windows doesn't support POSIX permissions
                }
                return "SUCCESS: File uploaded as " + uniqueFilename;
            } catch (Exception e) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException ignored) {
                }
                throw e;
            }
        } catch (IllegalArgumentException | SecurityException e) {
            return "ERROR: " + e.getMessage();
        } catch (IOException e) {
            return "ERROR: Failed to upload file";
        }
    }

    private String generateUniqueFilename(String originalFilename) {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[8];
        random.nextBytes(randomBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : randomBytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        String extension = getFileExtension(originalFilename);
        String baseName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));

        return baseName + "_" + sb.toString() + "." + extension;
    }

    public static void main(String[] args) {
        try {
            String testDir = System.getProperty("java.io.tmpdir") + File.separator + "test_uploads";
            Task50 uploader = new Task50(testDir);

            // Test case 1: Valid text file
            String result1 = uploader.uploadFile("test1.txt", "Hello World".getBytes(StandardCharsets.UTF_8));
            System.out.println("Test 1: " + result1);

            // Test case 2: Valid PDF file
            byte[] pdfContent = new byte[1024];
            new SecureRandom().nextBytes(pdfContent);
            String result2 = uploader.uploadFile("document.pdf", pdfContent);
            System.out.println("Test 2: " + result2);

            // Test case 3: Invalid filename (path traversal attempt)
            String result3 = uploader.uploadFile("../etc/passwd.txt", "malicious".getBytes(StandardCharsets.UTF_8));
            System.out.println("Test 3: " + result3);

            // Test case 4: File too large
            byte[] largeContent = new byte[(int) (MAX_FILE_SIZE + 1)];
            String result4 = uploader.uploadFile("large.txt", largeContent);
            System.out.println("Test 4: " + result4);

            // Test case 5: Invalid file extension
            String result5 = uploader.uploadFile("malware.exe", "test".getBytes(StandardCharsets.UTF_8));
            System.out.println("Test 5: " + result5);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
