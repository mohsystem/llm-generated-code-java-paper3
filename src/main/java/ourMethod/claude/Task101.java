package ourMethod.claude;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class Task101 {

    public static boolean createExecutableScript(String baseDirectory, String filename) {
        if (baseDirectory == null || filename == null || baseDirectory.isEmpty() || filename.isEmpty()) {
            return false;
        }

        if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            return false;
        }

        try {
            Path basePath = Paths.get(baseDirectory).toAbsolutePath().normalize();
            Path filePath = basePath.resolve(filename).normalize();

            if (!filePath.startsWith(basePath)) {
                return false;
            }

            if (Files.exists(filePath)) {
                if (!Files.isRegularFile(filePath) || Files.isSymbolicLink(filePath)) {
                    return false;
                }
            }

            Path tempFile = Files.createTempFile(basePath, ".tmp", ".sh");

            try {
                Files.write(tempFile, "#!/bin/bash\n".getBytes(java.nio.charset.StandardCharsets.UTF_8));

                String os = System.getProperty("os.name").toLowerCase();
                if (os.contains("win")) {
                    Files.move(
                            tempFile,
                            filePath,
                            StandardCopyOption.ATOMIC_MOVE,
                            StandardCopyOption.REPLACE_EXISTING
                    );
                } else {
                    Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-xr-x");
                    Files.setPosixFilePermissions(tempFile, perms);
                    Files.move(
                            tempFile,
                            filePath,
                            StandardCopyOption.ATOMIC_MOVE,
                            StandardCopyOption.REPLACE_EXISTING
                    );
                }

                return true;
            } catch (Exception e) {
                Files.deleteIfExists(tempFile);
                throw e;
            }
        } catch (IOException | UnsupportedOperationException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String testDir = System.getProperty("java.io.tmpdir");

        System.out.println("Test 1 (valid): " + createExecutableScript(testDir, "script.sh"));
        System.out.println("Test 2 (valid different name): " + createExecutableScript(testDir, "test_script.sh"));
        System.out.println("Test 3 (path traversal attempt): " + createExecutableScript(testDir, "../script.sh"));
        System.out.println("Test 4 (null filename): " + createExecutableScript(testDir, null));
        System.out.println("Test 5 (empty filename): " + createExecutableScript(testDir, ""));
    }
}
